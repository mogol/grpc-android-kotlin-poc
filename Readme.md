# Example: Android + Kotlin + gRPC + Protobuf
Default examples of Java Android and Protobuf code generation don't work with Kotlin. It happens because of wrong gradle tasks order. In this example separate module `helloproto` for Protobuf was added as dependency of main app. This allows to run task `generateDebugProto`/`generateReleaseProto` before `compileDebugKotlin`/`compileReleaseKotlin`
