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

import llvm.LLVMUnnamedAddr

public actual enum class UnnamedAddr(public val llvm: LLVMUnnamedAddr) {
  None(LLVMUnnamedAddr.LLVMNoUnnamedAddr),
  Local(LLVMUnnamedAddr.LLVMLocalUnnamedAddr),
  Global(LLVMUnnamedAddr.LLVMGlobalUnnamedAddr);

  public actual val value: UInt get() = llvm.value

  public actual companion object {
    public fun byValue(llvm: LLVMUnnamedAddr): UnnamedAddr {
      return byValue(llvm.value)
    }

    public actual fun byValue(value: Int): UnnamedAddr {
      return byValue(value.toUInt())
    }

    public actual fun byValue(value: UInt): UnnamedAddr {
      return values().single { it.llvm.value == value }
    }
  }
}
