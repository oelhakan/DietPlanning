package pl.edu.pwr.dietplanning

import pl.edu.pwr.dietplanning.callback.stepsCallback
import pl.edu.pwr.dietplanning.helper.GeneralHelper
import pl.edu.pwr.dietplanning.service.StepDetectorService
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.pedometer.*

class peodmeter : AppCompatActivity(), stepsCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.pedometer)

        val intent = Intent(this, StepDetectorService::class.java)
        startService(intent)

        StepDetectorService.subscribe.register(this)
    }

    override fun subscribeSteps(steps: Int) {
        TV_STEPS.setText(steps.toString())
        TV_CALORIES.setText(GeneralHelper.getCalories(steps))
        TV_DISTANCE.setText(GeneralHelper.getDistanceCovered(steps))
    }
}