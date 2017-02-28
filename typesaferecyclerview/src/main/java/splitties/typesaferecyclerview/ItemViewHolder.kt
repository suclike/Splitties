/*
 * Copyright (c) 2017. Louis Cognault Ayeva Derman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package splitties.typesaferecyclerview

import android.support.annotation.LayoutRes
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup

abstract class ItemViewHolder<Data : Any, V : View, Host>(protected val host: Host, itemView: V)
    : ViewHolder<V>(itemView) {

    lateinit var data: Data
        private set

    constructor(host: Host, @LayoutRes layoutResId: Int, parent: ViewGroup)
            : this(host, parent.inflate(layoutResId, false))

    /**
     * Don't create objects, use non inlied lambdas, or call methods doing so in this callback
     * as it may be called a lot of times as the user scrolls faster and faster, and allocating
     * memory could affect the UI smoothness.
     * @see data
     */
    abstract protected fun V.bind()

    /** To be called from your [RecyclerView.Adapter.onBindViewHolder] implementation. */
    fun bind(newData: Data) {
        data = newData
        itemView.bind()
    }
}
