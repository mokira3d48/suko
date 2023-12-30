/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package mokira.suko.compiler;

/**
 *
 * @author mokira3d48
 */
@FunctionalInterface
public interface Handler<I, O> {
  O process(I input);
}
