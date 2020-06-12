package org.paradisehell.asm.pratice;

import java.io.IOException;
import org.objectweb.asm.ClassReader;

public final class ClassPrinterMain {
  public static void main(String[] args) throws IOException {
    ClassPrinter cp = new ClassPrinter();
    ClassReader cr = new ClassReader("java.lang.Integer");
    cr.accept(cp, 0);
  }
}
