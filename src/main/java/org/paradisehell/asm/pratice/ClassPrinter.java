package org.paradisehell.asm.pratice;

import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.Attribute;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public final class ClassPrinter extends ClassVisitor {
  public ClassPrinter() {
    super(Opcodes.ASM8);
  }

  @Override
  public void visit(
      int version,
      int access,
      String name,
      String signature,
      String superName,
      String[] interfaces) {
    super.visit(version, access, name, signature, superName, interfaces);
    System.out.println(name + " extends " + superName + " { ");
  }

  @Override
  public void visitSource(String source, String debug) {
    super.visitSource(source, debug);
  }

  @Override
  public void visitOuterClass(String owner, String name, String descriptor) {
    super.visitOuterClass(owner, name, descriptor);
  }

  @Override
  public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
    return super.visitAnnotation(descriptor, visible);
  }

  @Override
  public void visitAttribute(Attribute attribute) {
    super.visitAttribute(attribute);
  }

  @Override
  public void visitInnerClass(String name, String outerName, String innerName, int access) {
    super.visitInnerClass(name, outerName, innerName, access);
  }

  @Override
  public FieldVisitor visitField(
      int access,
      String name,
      String descriptor,
      String signature,
      Object value) {
    System.out.println("\t" + descriptor + " " + name);
    return super.visitField(access, name, descriptor, signature, value);
  }

  @Override
  public MethodVisitor visitMethod(
      int access,
      String name,
      String descriptor,
      String signature,
      String[] exceptions) {
    System.out.println("\t" + name + descriptor);
    return super.visitMethod(access, name, descriptor, signature, exceptions);
  }

  @Override
  public void visitEnd() {
    super.visitEnd();
    System.out.println("}");
  }
}
