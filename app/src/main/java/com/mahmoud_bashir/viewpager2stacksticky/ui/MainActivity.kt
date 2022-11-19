package com.mahmoud_bashir.viewpager2stacksticky.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.mahmoud_bashir.viewpager2stacksticky.R
import com.mahmoud_bashir.viewpager2stacksticky.databinding.ActivityMainBinding
import com.mahmoud_bashir.viewpager2stacksticky.listOfPhotos
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )


        binding.viewpager.apply {
            adapter = PhotosPagerAdapter(listOfPhotos())
            offscreenPageLimit = 3
            setPageTransformer(SliderTransformer(3))
        }

        lifecycleScope.launch {
            reverseItSelf()
        }


    }

    private suspend fun reverseItSelf():Unit{
        if (reverseCount == 0){
            for (p in listOfPhotos().indices){

                    binding.viewpager.setCurrentItem(++reverseCount,true)
                    delay(1000)
                    if (reverseCount == listOfPhotos().size) {
                        return reverseItSelf()
                    }
                }
        }else{
            for (p in listOfPhotos().indices){
                binding.viewpager.setCurrentItem(reverseCount--,true)
                delay(1000)
                if (reverseCount == 0) {
                    return reverseItSelf()
                }
            }
        }

    }

    companion object{
         var reverseCount  = 0
    }
}