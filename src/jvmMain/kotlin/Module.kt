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

package org.plank.llvm4k

import org.plank.llvm4k.ir.AddrSpace
import org.plank.llvm4k.ir.Constant
import org.plank.llvm4k.ir.Function
import org.plank.llvm4k.ir.FunctionType
import org.plank.llvm4k.ir.GlobalAlias
import org.plank.llvm4k.ir.GlobalIFunc
import org.plank.llvm4k.ir.GlobalVariable
import org.plank.llvm4k.ir.PointerType
import org.plank.llvm4k.ir.StructType
import org.plank.llvm4k.ir.Type

public actual class Module : Disposable {
  public actual val context: Context
    get() = TODO("Not yet implemented")

  public actual var inlineAsm: String
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var sourceFilename: String
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual var moduleIdentifier: String
    get() = TODO("Not yet implemented")
    set(value) {}
  public actual var dataLayout: String
    get() = TODO("Not yet implemented")
    set(value) {}

  public actual fun dump(file: String) {
  }

  public actual fun appendInlineAsm(asm: String) {
  }

  public actual fun writeBitcode(file: String) {
  }

  public actual fun createJITExecutionEngine(level: OptimizationLevel): ExecutionEngine {
    TODO("Not yet implemented")
  }

  public actual fun getTypeByName(name: String): StructType? {
    TODO("Not yet implemented")
  }

  public actual fun getGlobalIFunc(name: String): GlobalIFunc? {
    TODO("Not yet implemented")
  }

  public actual fun addGlobalIFunc(
    name: String,
    type: FunctionType,
    addrSpace: AddrSpace,
    resolver: Function?
  ): GlobalIFunc {
    TODO("Not yet implemented")
  }

  public actual fun getGlobalVariable(name: String): GlobalVariable? {
    TODO("Not yet implemented")
  }

  public actual fun addGlobalVariable(
    name: String,
    type: Type,
    addrSpace: AddrSpace
  ): GlobalVariable {
    TODO("Not yet implemented")
  }

  public actual fun getGlobalAlias(name: String): GlobalAlias? {
    TODO("Not yet implemented")
  }

  public actual fun addGlobalAlias(
    name: String,
    type: PointerType,
    constant: Constant
  ): GlobalAlias {
    TODO("Not yet implemented")
  }

  public actual fun getFunction(name: String): Function? {
    TODO("Not yet implemented")
  }

  public actual fun addFunction(
    name: String,
    type: FunctionType
  ): Function {
    TODO("Not yet implemented")
  }

  public actual fun verify() {
  }

  public override fun close() {
    TODO("Not yet implemented")
  }

  public actual override fun toString(): String {
    TODO("Not yet implemented")
  }
}
