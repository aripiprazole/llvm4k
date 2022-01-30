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

package org.plank.llvm4k.ir

public actual class BasicBlock {
  public actual val name: String
    get() = TODO("Not yet implemented")
  public actual val function: Function?
    get() = TODO("Not yet implemented")
  public actual val asValue: AsValue
    get() = TODO("Not yet implemented")

  public actual fun moveAfter(target: BasicBlock) {
  }

  public actual fun moveBefore(target: BasicBlock) {
  }

  public actual fun delete() {
  }

  public actual fun erase() {
  }

  public actual override fun toString(): String {
    TODO("Not yet implemented")
  }

  public actual class AsValue : Value()
}
