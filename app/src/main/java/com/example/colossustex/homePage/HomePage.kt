package com.example.colossustex.homePage


import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.example.colossustex.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.database.*
import org.w3c.dom.Text


class HomePage : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var mDialog1: Dialog
    private lateinit var mDialog2: Dialog
    private lateinit var mDb: DatabaseReference

    private lateinit var viewModel: HomePageViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val lay = inflater.inflate(R.layout.home_page_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomePageViewModel::class.java)

        mDialog1 = Dialog(context!!)             //Used for showing Dialog
        mDialog2 = Dialog(context!!)             //Used for showing Dialog

        mDb = FirebaseDatabase.getInstance().reference

        recyclerView = lay.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        val options = FirebaseRecyclerOptions.Builder<Item>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("Item"), Item::class.java)
            .build()
        val item0=Item("Global Spinning Mills","Mill's rate in USD,contact details and product range")
        val item1=Item("Spinning Mills of India","Mill's rate in INR,contact details and product range")
        val item2= Item("Import Yarn from India","Mill's rate in USD, contact details and product range")
        val item3=Item("But-Sell Textile Products","Fabrics,garments,stock-lots, waste")
        val item4=Item("Yarn Offers","Special offers directly from spinning mills")
        val item5=Item("Buy Yarn Online","Colossustex will coordinate your purchase")
        val item6=Item("Post Yarn Requirement","Mills and agents will contact you directly")
        val item7=Item("Latest Textile News","News that affects your textile business")
        val item8=Item("Live Cotton, Crude, Currencies","ICE, MCX, NCDEX futures, crude and currencies")
        val mainlist= mutableListOf<Item>(item0,item1,item2,item3,item4,item5,item6,item7,item8)
        adapter = ItemAdapter(mainlist)
        recyclerView.adapter = adapter
        val toolbar = lay.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notification_Settings -> notificationSetting()
                R.id.edit_profile -> modifyProfile()
                R.id.change_password -> changePassword()
                R.id.spinning_mill -> spinningMill()
                R.id.support -> support()
                R.id.advertise_with_us -> advertiseWithUs()
                R.id.rate_this_app -> Toast.makeText(
                    context,
                    "Rate This App",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.share_app -> Toast.makeText(context, "Share App", Toast.LENGTH_SHORT).show()
            }
            true
        }        //menu items on click listeners


        return lay
    }                           //main code


    private fun notificationSetting() {                     //Add on click handlers to all switches
        mDialog1.setContentView(R.layout.home_page_notification_setting)
        val close = mDialog1.findViewById<TextView>(R.id.closeButtonNotificationSetting)
        val switch1 = mDialog1.findViewById<Switch>(R.id.switch1)
        val switch2 = mDialog1.findViewById<Switch>(R.id.switch2)
        val switch3 = mDialog1.findViewById<Switch>(R.id.switch3)
        val switch4 = mDialog1.findViewById<Switch>(R.id.switch4)
        val switch5 = mDialog1.findViewById<Switch>(R.id.switch5)
        val switch6 = mDialog1.findViewById<Switch>(R.id.switch6)
        close.setOnClickListener {
            mDialog1.dismiss()
        }
        switch1.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(
                context,
                "Notifications for Indian cotton prices: $state",
                Toast.LENGTH_SHORT
            ).show()
        }
        switch2.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(
                context,
                "Notifications for Indian domestic prices: $state",
                Toast.LENGTH_SHORT
            ).show()
        }
        switch3.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(
                context,
                "Notifications for Indian export yarn prices: $state",
                Toast.LENGTH_SHORT
            ).show()
        }
        switch4.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(
                context,
                "Notifications for Bangladeshi yarn prices: $state",
                Toast.LENGTH_SHORT
            ).show()
        }
        switch5.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(context, "Notifications with sound: $state", Toast.LENGTH_SHORT).show()
        }
        switch6.setOnCheckedChangeListener { compoundButton, state ->
            Toast.makeText(context, "Notifications with vibration: $state", Toast.LENGTH_SHORT)
                .show()
        }

        mDialog1.show()
    }    // code for notification Settings option in menu

    private fun modifyProfile() {//store values in temp variable on click and validate each value and navigate to next page
        mDialog1.setContentView(R.layout.home_page_modify_profile_1)
        var tempCountry: String
        var tempMobile: String
        var tempName: String
        var tempEmail: String
        var tempCity: String
        var count = 0

        val editTextCountry = mDialog1.findViewById<TextInputLayout>(R.id.editText_country)
        val editTextMobile = mDialog1.findViewById<TextInputLayout>(R.id.editText_mobile)
        val editTextName = mDialog1.findViewById<TextInputLayout>(R.id.editText_name)
        val editTextEmail = mDialog1.findViewById<TextInputLayout>(R.id.editText_Email)
        val editTextCity = mDialog1.findViewById<TextInputLayout>(R.id.editText_city)
        val buttonNext = mDialog1.findViewById<Button>(R.id.button_next)

        editTextCountry.editText!!.keyListener = null
        editTextMobile.editText!!.keyListener = null

        mDb.child("user").addValueEventListener(
            object : ValueEventListener {
                override fun onDataChange(data: DataSnapshot) {
                    val country = data.child("country").value.toString()
                    val mobile = data.child("mobile").value.toString()
                    val name = data.child("name").value.toString()
                    val email = data.child("email").value.toString()
                    val city = data.child("city").value.toString()
                    editTextCountry.editText?.setText(country)
                    editTextMobile.editText?.setText(mobile)
                    editTextName.editText?.setText(name)
                    editTextEmail.editText?.setText(email)
                    editTextCity.editText?.setText(city)

                }

                override fun onCancelled(p0: DatabaseError) {
                }

            }
        )


        //code for next button click:-
        buttonNext.setOnClickListener {

            tempCountry = editTextCountry.editText?.text.toString()
            tempMobile = editTextMobile.editText?.text.toString()
            tempName = editTextName.editText?.text.toString()
            tempEmail = editTextEmail.editText?.text.toString()
            tempCity = editTextCity.editText?.text.toString()

            if (tempCountry == "") {
                editTextCountry.error = "Field can't be empty"
            } else {
                editTextCountry.error = null
                count++
            }
            if (tempMobile == "") {
                editTextMobile.error = "Field can't be empty"
            } else {
                editTextMobile.error = null
                count++
            }
            if (tempName == "") {
                editTextName.error = "Field can't be empty"
            } else {
                editTextName.error = null
                count++
            }
            if (tempEmail == "") {
                editTextEmail.error = "Field can't be empty"
            } else {
                editTextEmail.error = null
                count++
            }
            if (tempCity == "") {
                editTextCity.error = "Field can't be empty"
            } else {
                editTextCity.error = null
                count++
            }

            if (count == 5) {    //all necessary fields filled
                mDialog1.hide()
                mDialog2.setContentView(R.layout.home_page_modify_profile_2)

                mDialog2.setOnKeyListener { dialogInterface, keyCode, keyEvent ->
                    //for back pressed in dialog2
                    //for back Key
                    if (keyCode == KeyEvent.KEYCODE_BACK) {
                        mDialog1.show()
                        mDialog2.dismiss()
                    }
                    true
                }


                //code for mDialog2 button click:-
                val editTextCompanyName =
                    mDialog2.findViewById<TextInputLayout>(R.id.editText_company_name)
                val editTextGSTNumber =
                    mDialog2.findViewById<TextInputLayout>(R.id.editText_GST_number)
                val editTextCompanyAddress =
                    mDialog2.findViewById<TextInputLayout>(R.id.editText_company_address)
                val editTextCompanyState =
                    mDialog2.findViewById<TextInputLayout>(R.id.editText_company_state)
                val editTextPinCode = mDialog2.findViewById<TextInputLayout>(R.id.editText_pin_code)
                val buttonModify = mDialog2.findViewById<Button>(R.id.button_modify)
                var count1 = 0

                buttonModify.setOnClickListener {

                    if (editTextCompanyName.editText?.text.toString().trim() == "") {
                        editTextCompanyName.error = "Field can't be empty"
                    } else {
                        editTextCompanyName.error = null
                        count1++
                    }

                    if (editTextCompanyAddress.editText?.text.toString().trim() == "") {
                        editTextCompanyAddress.error = "Field can't be empty"
                    } else {
                        editTextCompanyAddress.error = null
                        count1++
                    }

                    if (editTextCompanyState.editText?.text.toString().trim() == "") {
                        editTextCompanyState.error = "Field can't be empty"
                    } else {
                        editTextCompanyState.error = null
                        count1++
                    }

                    if (editTextPinCode.editText?.text.toString().trim() == "") {
                        editTextPinCode.error = "Field can't be empty"
                    } else {
                        editTextPinCode.error = null
                        count1++
                    }

                    if (count1 == 4) {     //all necessary fields filled
                        Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()
                        mDialog1.dismiss()
                        mDialog2.dismiss()
                    } else {
                        count1 = 0
                    }
                }

                mDialog2.show()
            } else {
                count = 0
            }

        }




        mDialog1.show()
    }          //code for modify Profile option in menu

    private fun changePassword() {
        mDialog1.setContentView(R.layout.home_page_change_password)
        val editTextCurrentPassword =
            mDialog1.findViewById<TextInputLayout>(R.id.editText_current_password)
        val editTextNewPassword = mDialog1.findViewById<TextInputLayout>(R.id.editText_new_password)
        val editTextConfirmPassword =
            mDialog1.findViewById<TextInputLayout>(R.id.editText_confirm_password)
        val buttonChangePassword = mDialog1.findViewById<Button>(R.id.button_change_password)
        val buttonDismiss = mDialog1.findViewById<TextView>(R.id.closeButtonChangePassword)

        buttonDismiss.setOnClickListener {
            mDialog1.dismiss()
        }

        var count = 0
        buttonChangePassword.setOnClickListener {

            if (editTextCurrentPassword.editText?.text.toString().trim() == "") {
                editTextCurrentPassword.error = "Field can't be empty"
            } else {
                editTextCurrentPassword.error = null
                count++
            }
            if (editTextNewPassword.editText?.text.toString().trim() == "") {
                editTextNewPassword.error = "Field can't be empty"
            } else {
                editTextNewPassword.error = null
                count++
            }
            if (editTextConfirmPassword.editText?.text.toString().trim() == "") {
                editTextConfirmPassword.error = "Field can't be empty"
            } else {
                editTextConfirmPassword.error = null
                count++
            }

            if (count == 3) {

                if (editTextNewPassword.editText?.text.toString().trim() ==
                    editTextConfirmPassword.editText?.text.toString().trim()
                ) {
                    mDialog1.dismiss()
                    Toast.makeText(context, "Password successfully saved", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    Toast.makeText(
                        context,
                        "New password do not match with confirm password!! Please try again",
                        Toast.LENGTH_LONG
                    )
                        .show()
                }

            } else {
                count = 0
            }

        }
        mDialog1.show()
    }         //code for change password option in main menu

    private fun spinningMill() {
        mDialog1.setContentView(R.layout.home_page_spinning_mill)
        val closeButton = mDialog1.findViewById<TextView>(R.id.closeButtonSpinningMill)
        val registerHere = mDialog1.findViewById<Button>(R.id.button_register_here)
        closeButton.setOnClickListener {
            mDialog1.dismiss()
        }
        registerHere.setOnClickListener {
            Toast.makeText(context, "Would open a web site link", Toast.LENGTH_SHORT).show()
            mDialog1.dismiss()
        }
        mDialog1.show()
    }           //code for spinning mill option in main menu

    private fun support() {
        mDialog1.setContentView(R.layout.home_page_support)
        val buttonClose = mDialog1.findViewById<TextView>(R.id.closeButtonSupport)
        val phone = mDialog1.findViewById<TextView>(R.id.textView_phone_no_support)
        val email = mDialog1.findViewById<TextView>(R.id.textView_email_support)
        buttonClose.setOnClickListener {
            mDialog1.dismiss()
        }
        phone.setOnClickListener {
            var intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9023428923")
            startActivity(intent)
        }
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,"support@coloussustex.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"")
            intent.putExtra(Intent.EXTRA_TEXT,"")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent,"Chose Email Clint:"))
        }
        mDialog1.show()
    }                //code for support option in main menu

    private fun advertiseWithUs() {
        mDialog1.setContentView(R.layout.home_page_advertise_with_us)
        val close = mDialog1.findViewById<TextView>(R.id.closeButtonAdvertiseWithUs)
        val phone = mDialog1.findViewById<TextView>(R.id.textView_phone_no_advertise)
        val email = mDialog1.findViewById<TextView>(R.id.textView_email_advertise)
        close.setOnClickListener {
            mDialog1.dismiss()
        }
        phone.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel:9023428923")
            startActivity(intent)
        }
        email.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.putExtra(Intent.EXTRA_EMAIL,"support@coloussustex.com")
            intent.putExtra(Intent.EXTRA_SUBJECT,"")
            intent.putExtra(Intent.EXTRA_TEXT,"")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent,"Chose Email Clint:"))
        }
        mDialog1.show()
    }      //code for advertise with us option in main menu

}
