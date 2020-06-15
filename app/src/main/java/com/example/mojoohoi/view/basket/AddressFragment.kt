package com.example.mojoohoi.view.basket

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.mojoohoi.R
import com.example.mojoohoi.client.dto.Basket
import com.example.mojoohoi.client.StorageComponent
import com.example.mojoohoi.dialog.SuccessDialog

class AddressFragment : Fragment() {
    var orderButton: Button? = null
    var storageComponent: StorageComponent? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.address_add, container, false)
        orderButton = root.findViewById(R.id.orderButton)

        initView();

        return root
    }

    private fun initView() {
        orderButton?.setOnClickListener({
            val successDialog = SuccessDialog(context, View.OnClickListener { successOrder() })
            successDialog.setCancelable(false)
            successDialog.show()
        })
    }

    private fun successOrder() {
        storageComponent = StorageComponent(context)
        storageComponent!!.setEventPayload(
            "historyItems",
            Basket.getInstance().order
        )//static history
        Basket.getInstance().removeOrder()
        activity?.setResult(Activity.RESULT_OK)
        activity?.finish()
    }
}
