package com.example.myapplication

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.example.helloproto.HelloGrpc
import com.example.helloproto.HelloOuterClass
import io.grpc.ManagedChannelBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun onSendClick(view: View) {
        GrpcTask().execute()
    }

    class GrpcTask: AsyncTask<Void, Void, String>() {
        val channel = ManagedChannelBuilder.forAddress("10.0.0.37",8081).usePlaintext(true).build()

        override fun doInBackground(vararg params: Void?): String {
            val stub = HelloGrpc.newBlockingStub(channel)
            val message = HelloOuterClass.HelloRequest.newBuilder().setText("Hello from Android").build()
            val reply = stub.get(message)
            Log.v("GrpcTask", reply.text)
            Log.v("GrpcTask", "finish")

            return reply.text
        }
    }
}
