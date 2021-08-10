package com.aliahmed.sondertechnicaltest.view

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.aliahmed.sondertechnicaltest.R
import com.aliahmed.sondertechnicaltest.adapter.PassengersAdapter
import com.aliahmed.sondertechnicaltest.adapter.PassengersLoadStateAdapter
import com.aliahmed.sondertechnicaltest.databinding.FragmentMapsBinding
import com.aliahmed.sondertechnicaltest.databinding.FragmentPassangerListBinding
import com.aliahmed.sondertechnicaltest.model.Passenger
import com.aliahmed.sondertechnicaltest.network.APIInterface
import com.aliahmed.sondertechnicaltest.utils.ItemClickListener
import com.aliahmed.sondertechnicaltest.viewmodel.PassengersViewModel
import com.aliahmed.sondertechnicaltest.viewmodel.PassengersViewModelFactory
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class PassengerListFragment : Fragment(), ItemClickListener {

    private var _binding: FragmentPassangerListBinding? = null
    private lateinit var viewModel: PassengersViewModel
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPassangerListBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val factory = PassengersViewModelFactory(APIInterface())
        viewModel = ViewModelProvider(this, factory).get(PassengersViewModel::class.java)

        val passengersAdapter = PassengersAdapter(this)
        binding.rvPassengerList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPassengerList.setHasFixedSize(true)

        binding.rvPassengerList.adapter = passengersAdapter.withLoadStateHeaderAndFooter(
            header = PassengersLoadStateAdapter { passengersAdapter.retry() },
            footer = PassengersLoadStateAdapter { passengersAdapter.retry() }
        )

        lifecycleScope.launch {
            viewModel.passengers.collectLatest { pagedData ->
                passengersAdapter.submitData(pagedData)
            }
        }
    }

    override fun itemClick(position: Int) {

    }

    override fun itemClick(position: Passenger) {
        Toast.makeText(context, position.name, Toast.LENGTH_LONG).show()
      //  val intent = Intent()
    }

}