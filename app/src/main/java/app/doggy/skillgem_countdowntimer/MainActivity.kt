package app.doggy.skillgem_countdowntimer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //残り時間のセット。
    var second = 10

    //タイマーを設定する。
    val timer: CountDownTimer = object : CountDownTimer(10000, 1000) {

        //タイマーが終了した時に呼ばれる。
        override fun onFinish() {

            //スタートボタンを表示する。
            startButton.isVisible = true

            //残り時間をリセットする。
            second = 10

            //残り時間を表示する。
            secondText.text = second.toString()

        }

        //カウントダウンされる毎に呼び出される。
        override fun onTick(p0: Long) {

            //残り時間を1秒減らす。
            second -= 1

            //残り時間を表示する。
            secondText.text = second.toString()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //残り時間を表示する。
        secondText.text = second.toString()

        //スタートボタンがタップされた時。
        startButton.setOnClickListener {

            //スタートボタンを見えない状態にする。
            startButton.isVisible = false

            //タイマーを開始する。
            timer.start()

        }
    }
}