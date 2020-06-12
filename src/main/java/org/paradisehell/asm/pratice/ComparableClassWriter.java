package org.paradisehell.asm.pratice;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/*
package pkg;
public interface Comparable extends Measurable {
  int LESS = -1;
  int EQUAL = 0;
  int GREATER = 1;
  int compareTo(Object o);
}
*/
public final class ComparableClassWriter {
  public static void main(String[] args) throws IOException {
    ClassWriter cw = new ClassWriter(0);
    cw.visit(
        Opcodes.V1_8,
        Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
        "pkg/Comparable",
        null,
        "java/lang/Object",
        new String[] {"pkg/Measurable"}
    );
    // int LESS = -1;
    cw.visitField(
        Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
        "LESS",
        "I",
        null,
        -1
    ).visitEnd();
    // int EQUAL = 0;
    cw.visitField(
        Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
        "EQUAL",
        "I",
        null,
        0
    ).visitEnd();
    // int GREATER = 1;
    cw.visitField(
        Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC,
        "GREATER",
        "I",
        null,
        1
    ).visitEnd();
    // int compareTo(Object o);
    cw.visitMethod(
        Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT,
        "compareTo",
        "(Ljava/lang/Object;)I",
        null,
        null
    ).visitEnd();
    //
    File file = new File("Comparable.class");
    FileOutputStream fos = new FileOutputStream(file);
    fos.write(cw.toByteArray());
    fos.flush();
    fos.close();
  }
}
