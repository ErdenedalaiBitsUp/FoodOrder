package com.example.myapplication.activity

import android.animation.Animator
import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.view.View.VISIBLE
import android.widget.*
import androidx.core.content.ContextCompat
import com.apptakk.http_request.HttpRequest
import com.apptakk.http_request.HttpRequestTask
import com.example.mojoohoi.R
import com.example.mojoohoi.activity.MainActivity
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : BaseActivity() {
    private var loadingProgressBar: ProgressBar? = null
    private var bookIconImageView: ImageView? = null
    private var bookITextView: TextView? = null
    private var rootView: RelativeLayout? = null
    private var afterAnimationView: RelativeLayout? = null
    private var userNameEditText: TextInputEditText? = null
    private var passwordEditText: TextInputEditText? = null
    private var loginButton: Button? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_activity)
        bookIconImageView = findViewById(R.id.bookIconImageView)
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
        loginButton = findViewById(R.id.loginButton);
        userNameEditText = findViewById(R.id.userNameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        initView();
    }

    private fun initView() {
        createCountTimer();
        loginButton?.setOnClickListener({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }

    private fun createCountTimer() {
        object : CountDownTimer(2000, 1000) {
            override fun onFinish() {
                bookITextView?.visibility = View.GONE
                loadingProgressBar?.visibility = View.GONE

                rootView?.setBackgroundColor(
                    ContextCompat.getColor(
                        this@LoginActivity,
                        R.color.colorBackground
                    )
                )
                startAnimation()
            }

            override fun onTick(p0: Long) {}
        }.start()
    }


    private fun startAnimation() {
        bookIconImageView?.animate()?.apply {
            bookIconImageView?.x?.let { x(it) }
            bookIconImageView?.y?.let { y(it - 400) }
            duration = 1000
        }?.setListener(object : Animator.AnimatorListener {
            override fun onAnimationRepeat(p0: Animator?) {

            }

            override fun onAnimationEnd(p0: Animator?) {
                afterAnimationView?.visibility = VISIBLE
                loginButton?.visibility = VISIBLE
            }

            override fun onAnimationCancel(p0: Animator?) {

            }

            override fun onAnimationStart(p0: Animator?) {

            }
        })
    }
}