package gst.trainingcourse.mockproject.fragment


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import gst.trainingcourse.adapter.BudgetAdapter
import gst.trainingcourse.adapter.SeekBarAdapter
import gst.trainingcourse.constants.Utils

import gst.trainingcourse.customizeUI.TextViewAnimation.Companion.startChangingNumber
import gst.trainingcourse.database.model.Budget
import gst.trainingcourse.mockproject.databinding.FragmentExpenseBinding
import gst.trainingcourse.viewmodel.BudgetViewModel


class ExpenseFragment : Fragment() {

    private val viewModel :BudgetViewModel by viewModels()
    private lateinit var budgetAdapter: BudgetAdapter

    private var _binding: FragmentExpenseBinding? = null
    private val binding get() = _binding!!

    private val number = 2400
    private val n = number / 10
    private val average = number / 6
    private var current: Int = 0
    private var previous: Int = 0
    private lateinit var seekBarAdapter: SeekBarAdapter

    private val seekBarList = ArrayList<Int>()
    private var linearLayoutManager: LinearLayoutManager? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentExpenseBinding.inflate(inflater, container, false)
        binding.number.text = ("$ $number")
        linearLayoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        binding.description.text = Utils.normal_des_1
        initRecycleView()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getData()
    }

    private fun getData() {
       viewModel.getBudgetList()
        viewModel.budgetList.observe(requireActivity() ,{
            budgetAdapter = BudgetAdapter(it as ArrayList<Budget>,requireContext())
            binding.scrollview.setHasFixedSize(true)
            binding.scrollview.layoutManager=LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            binding.scrollview.adapter=budgetAdapter

        })
    }

    private fun displayStatus(number: Int) {
        if (number <= average * 2) {
            binding.status.text = Utils.normal
            binding.description.text = Utils.normal_des_1
        } else if (number > average * 2 && number <= average * 3) {
            binding.status.text = Utils.alot
            binding.description.text = Utils.alot_des_1
        } else if (number > average * 3) {
            binding.status.text = Utils.crazy
            binding.description.text = Utils.crazy_des_1
        }

    }

    private fun initRecycleView() {
        for (i in 0..n) {
            seekBarList.add(i)
        }
        seekBarAdapter = SeekBarAdapter(seekBarList, requireContext())
        binding.recChooseNumber.setHasFixedSize(true)
        binding.recChooseNumber.layoutManager = linearLayoutManager
        binding.recChooseNumber.adapter = seekBarAdapter

        setScrollListener()

    }

    private fun setScrollListener() {
        binding.recChooseNumber.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                val visiblePosition = linearLayoutManager!!.findFirstVisibleItemPosition()
                current = visiblePosition + 4

                val handler = Handler()
                handler.postDelayed({
                    previous = current
                }, 1)

                when {
                    current == 4 -> {
                        startChangingNumber(0, 10 * current, binding.amount,binding.status,binding.description)
                    }
                    visiblePosition >= n / 2 -> {
                        binding.amount.text = (10 * n / 2).toString()
                    }
                    else -> {
                        startChangingNumber(10 * previous, 10 * current, binding.amount,binding.status,binding.description)
                    }
                }
                displayStatus(10 * current)


            }
        })

    }





}