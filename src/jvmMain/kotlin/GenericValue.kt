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

import org.plank.llvm4k.ir.IntegerType
import org.plank.llvm4k.ir.Type

public actual sealed interface GenericValue<A> : Disposable {
  public actual val type: Type
  public actual val value: A
}

public actual class AnyValue public actual constructor(type: Type, value: Any) :
  GenericValue<Any?> {
  public override val type: Type
    get() = TODO("Not yet implemented")

  public override val value: Any?
    get() = TODO("Not yet implemented")

  public override fun close() {
    TODO("Not yet implemented")
  }
}

public actual class FloatValue public actual constructor(
  type: Type,
  value: Int
) : GenericValue<Float> {
  public override val type: Type
    get() = TODO("Not yet implemented")

  public override val value: Float
    get() = TODO("Not yet implemented")

  public override fun close() {
    TODO("Not yet implemented")
  }
}

public actual class IntegerValue public actual constructor(
  type: IntegerType,
  value: Int,
  signed: Boolean
) : GenericValue<Int> {
  public actual val signed: Boolean
    get() = TODO("Not yet implemented")

  public override val type: Type
    get() = TODO("Not yet implemented")

  public override val value: Int
    get() = TODO("Not yet implemented")

  public override fun close() {
    TODO("Not yet implemented")
  }
}
