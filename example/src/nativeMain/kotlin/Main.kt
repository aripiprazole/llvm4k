/*
 *    Copyright 2022 Plank
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.plank.llvm4k.example

import org.plank.llvm4k.Context
import org.plank.llvm4k.OptimizationLevel
import org.plank.llvm4k.ir.AddrSpace
import org.plank.llvm4k.ir.CallingConv
import org.plank.llvm4k.ir.FunctionType
import org.plank.llvm4k.ir.Linkage

fun main() {
  llvm.LLVMInitializeNativeAsmPrinter()
  llvm.LLVMInitializeNativeAsmParser()

  val context = Context()
  val module = context.createModule("test")

  val builder = context.createIRBuilder()

  val printf =
    FunctionType(context.void, context.i8.pointer(AddrSpace.Generic), isVarargs = true)
      .let { module.addFunction("printf", it) }
      .apply {
        callingConv = CallingConv.C
        linkage = Linkage.External
      }

  context.createNamedStruct("Person") {
    elements = listOf(context.i8.pointer(AddrSpace.Generic), context.i32)
  }

  val main = FunctionType(context.void).let { module.addFunction("main", it) }.apply {
    builder.apply {
      val message by createGlobalString("Hello, world")

      positionAfter(context.createBasicBlock("entry").also(::appendBasicBlock))

      createCall(printf, message)
      createRetVoid()
    }
  }

  val engine = module.createJITExecutionEngine(OptimizationLevel.None)

  engine.runFunction(main)
}
