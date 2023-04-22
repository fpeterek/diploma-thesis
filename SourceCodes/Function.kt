package org.fpeterek.tilscript.math

import org.fpeterek.tilscript.common.SrcPosition
import org.fpeterek.tilscript.common.interpreterinterface.DefaultFunction
import org.fpeterek.tilscript.common.interpreterinterface.FnCallContext
import org.fpeterek.tilscript.common.interpreterinterface.InterpreterInterface
import org.fpeterek.tilscript.common.sentence.*
import org.fpeterek.tilscript.common.types.Primitives
import kotlin.math.*

object Sin : DefaultFunction(
    "Sin",
    Primitives.Real,
    listOf(
        Variable("x", SrcPosition(-1, -1), Primitives.Real)
    )
) {

    override fun apply(
        interpreter: InterpreterInterface,
        args: List<Construction>,
        ctx: FnCallContext
    ): Construction {

        val x = args[0]

        if (x is Symbol && x.value == "Pi" &&
                interpreter.typesMatch(x.constructionType, Primitives.Real)) {
            return Real(value = 0.0, srcPos = ctx.position)
        }

        if (x is Symbol) {
            return Nil(
                ctx.position,
                reason="Cannot compute the sine of a symbolic value"
            )
        }

        x as Real

        return Real(sin(x.value), ctx.position)
    }

}
