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

import org.plank.llvm4k.ir.BasicBlock
import org.plank.llvm4k.ir.FloatType
import org.plank.llvm4k.ir.IntegerType
import org.plank.llvm4k.ir.LabelType
import org.plank.llvm4k.ir.MetadataType
import org.plank.llvm4k.ir.StructType
import org.plank.llvm4k.ir.TokenType
import org.plank.llvm4k.ir.VoidType
import org.plank.llvm4k.ir.X86MMXType

public actual interface Context : Disposable {
  public actual val void: VoidType
  public actual val i1: IntegerType
  public actual val i8: IntegerType
  public actual val i16: IntegerType
  public actual val i32: IntegerType
  public actual val i64: IntegerType
  public actual val i128: IntegerType
  public actual val float: FloatType
  public actual val bfloat: FloatType
  public actual val half: FloatType
  public actual val double: FloatType
  public actual val x86fp80: FloatType
  public actual val fp128: FloatType
  public actual val ppcFP128: FloatType
  public actual val x86MMX: X86MMXType
  public actual val label: LabelType
  public actual val metadata: MetadataType
  public actual val token: TokenType
  public actual fun createBasicBlock(name: String): BasicBlock
  public actual fun createIRBuilder(): IRBuilder
  public actual fun createIntegerType(bits: Int): IntegerType
  public actual fun createNamedStruct(name: String, builder: StructType.() -> Unit): StructType

  public actual fun createModule(name: String): Module
}

public actual object GlobalContext : Context by Context()

@JsName("Context0")
public actual fun Context(): Context {
  TODO("Not yet implemented")
}
