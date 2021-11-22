package com.example.rpsgamechapter4

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {

    private lateinit var ivRockPemain1: ImageView
    private lateinit var ivPaperPemain1: ImageView
    private lateinit var ivScissorPemain1: ImageView
    private lateinit var ivRockCom: ImageView
    private lateinit var ivPaperCom: ImageView
    private lateinit var ivScissorCom: ImageView
    private lateinit var ivRestart: ImageView
    private lateinit var tvResult: TextView

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ivRockPemain1 = findViewById(R.id.ivRockPemain1)
        ivPaperPemain1 = findViewById(R.id.ivPaperPemain1)
        ivScissorPemain1 = findViewById(R.id.ivScissorPemain1)
        ivRockCom = findViewById(R.id.ivRockCom)
        ivPaperCom = findViewById(R.id.ivPaperCom)
        ivScissorCom = findViewById(R.id.ivScissorCom)
        ivRestart = findViewById(R.id.ivRestart)
        tvResult = findViewById(R.id.tvResult)

        val btnPemain1 = arrayOf(ivRockPemain1, ivPaperPemain1, ivScissorPemain1)
        val btnCom = arrayOf(ivRockCom, ivPaperCom, ivScissorCom)

        btnPemain1.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                val dataCom = btnCom.random()
                logicGame(btnPemain1[index].contentDescription, dataCom.contentDescription)
                dataCom.setBackgroundResource(R.drawable.bg_image)
                cekKlikPemain(ivPaperPemain1, ivScissorPemain1, ivRockPemain1)
                Toast.makeText(this, btnPemain1[index].contentDescription, Toast.LENGTH_SHORT)
                    .show()
                btnPemain1.forEach {
                    it.setBackgroundResource(android.R.color.transparent)
                }
                btnPemain1[index].setBackgroundResource(R.drawable.bg_image)
            }
        }

        ivRestart.setOnClickListener {
            Toast.makeText(this, "Mulai ulang permainan", Toast.LENGTH_SHORT).show()
            ivRockPemain1.setBackgroundResource(android.R.color.transparent)
            ivPaperPemain1.setBackgroundResource(android.R.color.transparent)
            ivScissorPemain1.setBackgroundResource(android.R.color.transparent)
            ivRockCom.setBackgroundResource(android.R.color.transparent)
            ivPaperCom.setBackgroundResource(android.R.color.transparent)
            ivScissorCom.setBackgroundResource(android.R.color.transparent)
            ivRestart.setBackgroundResource(android.R.color.transparent)
            resertClick(ivPaperPemain1, ivScissorPemain1, ivRockPemain1)
            tvResult.setBackgroundResource(android.R.color.transparent)
            tvResult.setText(R.string.vs)
            tvResult.setTextColor(getColor(R.color.merah))
            tvResult.setTextSize(50f)
            Log.d("result", "mulai ulang permainan")
        }
    }

    private fun cekKlikPemain(
        imgPemain1Kertas: ImageView,
        imgPemain1Gunting: ImageView,
        imgPemain1Batu: ImageView
    ) {
        imgPemain1Gunting.isEnabled = false
        imgPemain1Kertas.isEnabled = false
        imgPemain1Batu.isEnabled = false
    }

    private fun resertClick(
        imgPemain1Kertas: ImageView,
        imgPemain1Gunting: ImageView,
        imgPemain1Batu: ImageView
    ) {
        imgPemain1Gunting.isEnabled = true
        imgPemain1Kertas.isEnabled = true
        imgPemain1Batu.isEnabled = true
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun logicGame(pemain1: CharSequence, pemain2: CharSequence) {
        if (pemain1 == pemain2) {
            tvResult.setBackgroundResource(R.drawable.bg_image)
            tvResult.setText(R.string.draw)
            tvResult.setTextColor(getColor(R.color.white))
            tvResult.setTextSize(16f)
            Log.d("result", "draw")
        } else if (pemain1 == ivRockPemain1.contentDescription && pemain2 == ivScissorCom.contentDescription || pemain1 == ivScissorPemain1.contentDescription && pemain2 == ivPaperCom.contentDescription || pemain1 == ivPaperPemain1.contentDescription && pemain2 == ivRockCom.contentDescription) {
            tvResult.setBackgroundResource(R.drawable.bg_result)
            tvResult.setText(R.string.pemain1menang)
            tvResult.setTextColor(getColor(R.color.white))
            tvResult.setTextSize(16f)
            Log.d("result", "pemain 1 menang")
        } else {
            tvResult.setBackgroundResource(R.drawable.bg_result)
            tvResult.setText(R.string.pemain2menang)
            tvResult.setTextColor(getColor(R.color.white))
            tvResult.setTextSize(16f)
            Log.d("result", "pemain 2 menang")
        }

    }
}