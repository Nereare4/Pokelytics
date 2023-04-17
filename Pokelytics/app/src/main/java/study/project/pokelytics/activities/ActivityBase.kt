package study.project.pokelytics.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class ActivityBase<T : ViewDataBinding> : AppCompatActivity() {

    lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, getResourceLayout())
        bindViewModel()
        initializeView()
        subscribe()
        setTopBar()
    }

    private fun setTopBar() {}

    protected abstract fun getResourceLayout(): Int

    protected abstract fun initializeView()

    protected abstract fun bindViewModel()

    protected abstract fun subscribe()

}