/*
 * Copyright (c) 2018. Louis Cognault Ayeva Derman
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
package splitties.viewdsl.constraintlayout

import android.content.Context
import android.support.annotation.IdRes
import android.support.annotation.StyleRes
import android.support.constraint.ConstraintLayout
import android.view.View
import splitties.viewdsl.core.NO_THEME
import splitties.viewdsl.core.Ui
import splitties.viewdsl.core.view

// ConstraintLayout

inline fun Context.constraintLayout(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: ConstraintLayout.() -> Unit = {}
): ConstraintLayout = view(::ConstraintLayout, id, theme, initView)

inline fun View.constraintLayout(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: ConstraintLayout.() -> Unit = {}
) = context.constraintLayout(id, theme, initView)

inline fun Ui.constraintLayout(
        @IdRes id: Int = View.NO_ID,
        @StyleRes theme: Int = NO_THEME,
        initView: ConstraintLayout.() -> Unit = {}
) = ctx.constraintLayout(id, theme, initView)
