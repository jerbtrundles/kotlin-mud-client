import androidx.compose.runtime.MutableState
import okhttp3.*

class WebSocketClient(
    val outputText: MutableState<String>,
    val debugLengthText: MutableState<String>,
    val roomText: MutableState<String>,
    val npcsText: MutableState<String>,
    val monstersText: MutableState<String>,
    val itemsText: MutableState<String>,
    val statsText: MutableState<String>,
    val debugText: MutableState<String>
) {
    private var webSocket: WebSocket? = null
    private val client = OkHttpClient()

    fun start() {
        val request = Request.Builder().url("ws://192.168.86.32:8080/ws").build()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            override fun onOpen(webSocket: WebSocket, response: Response) {
                println("open")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                when {
                    text.startsWith("MONSTERS:") -> monstersText.value = text.substringAfter(":")
                    text.startsWith("NPCS:") -> npcsText.value = text.substringAfter(":")
                    text.startsWith("ROOM:") -> roomText.value = text.substringAfter(":")
                    text.startsWith("ITEMS:") -> itemsText.value = text.substringAfter(":")
                    text.startsWith("STATS:") -> statsText.value = text.substringAfter(":")
                    text.startsWith("DEBUG:") -> debugText.value = text.substringAfter(":")
                    else -> appendAndTrimOutputText(text)
                }
            }

            private fun appendAndTrimOutputText(text: String) {
                    outputText.value += text + "\n\n"
                    while (outputText.value.length > 2000) {
                        outputText.value =
                            outputText.value.substring(outputText.value.indexOf("\n") + 1)
                    }

                    debugLengthText.value = outputText.value.length.toString()
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                println("closing")
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                println("failure")
            }
        })
    }

    fun stop() = webSocket?.close(1000, null)

    fun sendMessage(message: String) {
        if (webSocket?.send(message) == true) {
            println("sendMessage() - success")
        } else {
            println("sendMessage() - failure")
        }
    }
}