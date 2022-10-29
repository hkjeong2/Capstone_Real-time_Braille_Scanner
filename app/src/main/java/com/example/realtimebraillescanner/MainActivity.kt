package com.example.realtimebraillescanner

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.realtimebraillescanner.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivityBinding
    private var REQUIRED_PERMISSIONS = arrayOf(Manifest.permission.CAMERA)
    private val PERMISSIONS_REQUEST_CODE = 100
    private var permissionToCamera = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickListener()

    }


    private fun initClickListener(){
        binding.tvConverterMain.setOnClickListener {
            checkRunTimePermission()
        }

        binding.tvSettings.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        permissionToCamera = if (requestCode == PERMISSIONS_REQUEST_CODE) {
            grantResults[0] == PackageManager.PERMISSION_GRANTED
        } else {
            false
        }
        if (!permissionToCamera){
            Toast.makeText(this, "설정에서 카메라 권한을 허용해주세요", Toast.LENGTH_LONG).show()
        }
        else{
            startActivity(Intent(this, CameraActivity::class.java))
        }
    }

    fun checkRunTimePermission() {
        //런타임 퍼미션 처리
        // 1. 카메라 퍼미션을 가지고 있는지 체크합니다.
        val hasCameraPermission = ContextCompat.checkSelfPermission(this@MainActivity, Manifest.permission.CAMERA)

        if (hasCameraPermission == PackageManager.PERMISSION_GRANTED) {
            // 2. 이미 퍼미션을 가지고 있다면 액티비티 이동
            startActivity(Intent(this, CameraActivity::class.java))
        } else {  //2. 퍼미션 요청을 허용한 적이 없다면 퍼미션 요청이 필요합니다. 2가지 경우(3-1, 4-1)가 있습니다.
            // 3-1. 사용자가 퍼미션 거부를 한 적이 있는 경우에는
            if (ActivityCompat.shouldShowRequestPermissionRationale(this@MainActivity, REQUIRED_PERMISSIONS.get(0))) {
                // 3-2. 요청을 진행하기 전에 사용자가에게 퍼미션이 필요한 이유를 설명해줄 필요가 있습니다.
                Toast.makeText(this, "카메라 권한이 필요합니다.", Toast.LENGTH_LONG).show()
                // 3-3. 사용자에게 퍼미션 요청을 합니다. 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                ActivityCompat.requestPermissions(this@MainActivity, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
            } else {
                // 4-1. 사용자가 퍼미션 거부를 한 적이 없는 경우에는 퍼미션 요청을 바로 합니다.
                // 요청 결과는 onRequestPermissionResult에서 수신됩니다.
                Toast.makeText(this, "카메라 권한을 허용해주세요.", Toast.LENGTH_LONG).show()
                ActivityCompat.requestPermissions(this@MainActivity, REQUIRED_PERMISSIONS, PERMISSIONS_REQUEST_CODE)
            }
        }
    }

}