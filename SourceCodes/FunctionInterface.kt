package org.fpeterek.tilscript.common.interpreterinterface

/* Imports */

// Only relevant code is highlighted in this code snippet
sealed class FunctionInterface constructor(
    val name: String,
    val returns: Type,
    val args: List<Variable>,
) {

    abstract val acceptsNil: Boolean

    val argTypes = args.map { it.constructedType }

    val signature = FunctionType(returns, argTypes)
    val tilFunction = TilFunction(
        name,
        SrcPosition(-1, -1),
        signature,
        implementation = this
    )

    protected fun checkArgCount(
        fnArgs: List<Construction>,
        ctx: FnCallContext) {
        /* Implementation */
    }

    protected fun checkArgTypes(
        interpreter: InterpreterInterface,
        fnArgs: List<Type>,
        ctx: FnCallContext) = /* Implementation */

    protected fun checkSignature(
        interpreter: InterpreterInterface,
        returned: Type,
        fnArgs: List<Type>,
        ctx: FnCallContext) {
        /* Implementation */
    }

    protected fun runWithTypechecks(
        interpreter: InterpreterInterface,
        args: List<Construction>,
        ctx: FnCallContext): Construction {
        /* Implementation */
    }

    abstract fun apply(
        interpreter: InterpreterInterface,
        args: List<Construction>,
        ctx: FnCallContext
    ): Construction

    abstract operator fun invoke(
        interpreter: InterpreterInterface,
        args: List<Construction>,
        ctx: FnCallContext
    ): Construction
}
