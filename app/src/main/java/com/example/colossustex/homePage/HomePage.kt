package com.example.colossustex.homePage


import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.colossustex.EmailLogin.UserRegister
import com.example.colossustex.EmailLogin.WelcomeActivity
import com.example.colossustex.EmailLogin.googleSignInClient
import com.example.colossustex.R
import com.example.colossustex.SG.yarn_requirements
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

fun modifyProfile(context: Context , to: Int = 0) {//store values in temp variable on click and validate each value and navigate to next page
    val mDialog1 = Dialog(context)
    val mDialog2 = Dialog(context)
    val mDb : DatabaseReference = FirebaseDatabase.getInstance().reference

    mDialog1.setContentView(R.layout.home_page_modify_profile_1)
    mDialog1.show()

    var tempCountry: String
    var tempMobile: String
    var tempName: String
    var tempEmail: String
    var tempCity: String
    var count = 0

    val editTextCountry = mDialog1.findViewById<TextInputLayout>(R.id.editText_country)
    val editTextMobile = mDialog1.findViewById<TextInputLayout>(R.id.editTextMobile)
    val editTextName = mDialog1.findViewById<TextInputLayout>(R.id.editText_name)
    val editTextEmail = mDialog1.findViewById<TextInputLayout>(R.id.editText_Email)
    val editTextCity = mDialog1.findViewById<TextInputLayout>(R.id.editText_city)
    val buttonNext = mDialog1.findViewById<Button>(R.id.button_next)


    val user = FirebaseAuth.getInstance().currentUser
    var cate = ""
    mDb.child("User/${user?.uid}/userData").addValueEventListener(
        object : ValueEventListener {
            override fun onDataChange(data: DataSnapshot) {
                val country = data.child("country").value.toString()
                val mobile = data.child("phone").value.toString()
                val name = data.child("name").value.toString()
                val email = data.child("email").value.toString()
                val city = data.child("city").value.toString()
                editTextCountry.editText?.setText(country)
                editTextMobile.editText?.setText(mobile)
                editTextName.editText?.setText(name)
                editTextEmail.editText?.setText(email)
                editTextCity.editText?.setText(city)
                cate = data.child("categary").value.toString()

            }

            override fun onCancelled(p0: DatabaseError) {
            }

        }
    )


    //code for next button click:-
    buttonNext.setOnClickListener {

        tempCountry = editTextCountry.editText?.text.toString().trim()
        tempMobile = editTextMobile.editText?.text.toString().trim()
        tempName = editTextName.editText?.text.toString().trim()
        tempEmail = editTextEmail.editText?.text.toString().trim()
        tempCity = editTextCity.editText?.text.toString().trim()

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
            mDialog2.show()

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

            mDb.child("User/${user?.uid}/userData").addValueEventListener(
                object : ValueEventListener {
                    override fun onDataChange(data: DataSnapshot) {
                        val companyName = data.child("companyName").value.toString()
                        val GST = data.child("gstnumber").value.toString()
                        val address = data.child("address").value.toString()
                        val state = data.child("state").value.toString()
                        val pin = data.child("pinCode").value.toString()


                        editTextCompanyName.editText?.setText(companyName)
                        editTextGSTNumber.editText?.setText(GST)
                        editTextCompanyState.editText?.setText(state)
                        editTextCompanyAddress.editText?.setText(address)
                        editTextPinCode.editText?.setText(pin)

                        cate = data.child("categary").value.toString()


                    }

                    override fun onCancelled(p0: DatabaseError) {
                    }

                }
            )

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

                    val info = UserRegister(
                        id = user!!.uid,
                        email = tempEmail,
                        name = tempName,
                        phone = tempMobile,
                        country = tempCountry,
                        city = tempCity,
                        categary = cate,
                        companyName = editTextCompanyName.editText?.text.toString().trim(),
                        GSTNumber = editTextGSTNumber.editText?.text.toString().trim(),
                        address = editTextCompanyAddress.editText?.text.toString().trim(),
                        state = editTextCompanyState.editText?.text.toString().trim(),
                        pinCode = editTextPinCode.editText?.text.toString().trim(),
                        flag = 1
                    )


                    val mref =
                        FirebaseDatabase.getInstance().getReference("User").child(user.uid)
                            .child("userData")
                    mref.setValue(info)
                    if(to == 1){
                        it.context.startActivity(Intent(it.context, yarn_requirements::class.java))
                    }
                    Toast.makeText(context, "Saved Successfully", Toast.LENGTH_SHORT).show()
                    mDialog1.show()
                    mDialog1.dismiss()
                    mDialog2.dismiss()
                } else {
                    count1 = 0
                }

            }

        } else {
            count = 0
        }

    }


}          //code for modify Profile option in menu

class HomePage : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemAdapter
    private lateinit var mDb: DatabaseReference
    private lateinit var viewModel: HomePageViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val lay = inflater.inflate(R.layout.home_page_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomePageViewModel::class.java)

        mDb = FirebaseDatabase.getInstance().reference

        recyclerView = lay.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
        val options = FirebaseRecyclerOptions.Builder<Item>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("Item"), Item::class.java)
            .build()
        val item0 =
            Item("Colossus Grow", "Mill's rate in USD,contact details and product range")
        val item1 =
            Item("Colossus Deal", "Mill's rate in INR,contact details and product range")
        val item2 =
            Item("Colossus Find", "Mill's rate in USD, contact details and product range")
        val item3 = Item("Buy Yarn Online", "Colossustex will coordinate your purchase")
        val item4 = Item("Colossus Mind", "Special offers directly from spinning mills")
        val item5 = Item("Colossus Move", "Colossustex will coordinate your purchase")
        val item6 = Item("Colossus Tech", "Mills and agents will contact you directly")
        val item7 = Item("Colossus Time", "News that affects your textile business")
        val item8 =
            Item("Colossus Edge", "ICE, MCX, NCDEX futures, crude and currencies")
        val item9 =
            Item("Colossus Meet", "ICE, MCX, NCDEX futures, crude and currencies")
        val item10 =
            Item("Colossus Wave", "ICE, MCX, NCDEX futures, crude and currencies")
        val item11 =
            Item("Colossus Care", "ICE, MCX, NCDEX futures, crude and currencies")
        val item12 =
            Item("Colossus Hire", "ICE, MCX, NCDEX futures, crude and currencies")
        val mainlist =
            mutableListOf<Item>(item0, item1, item2, item3, item4, item5, item6, item7, item8, item9, item10, item11)
        adapter = ItemAdapter(mainlist , context!!)
        recyclerView.adapter = adapter
        val toolbar = lay.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.main_menu)
        toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.notification_Settings -> notificationSetting(context!!)
                R.id.edit_profile -> modifyProfile(context!!)
                R.id.change_password -> changePassword(context!!)
                R.id.spinning_mill -> spinningMill(context!!)
                R.id.support -> support(context!!)
                R.id.advertise_with_us -> advertiseWithUs(context!!)
                R.id.rate_this_app -> Toast.makeText(
                    context,
                    "Rate This App",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.share_app -> Toast.makeText(context, "Share App", Toast.LENGTH_SHORT).show()
                R.id.logout_menu -> {
                    val auth = FirebaseAuth.getInstance()
                    auth.signOut()
                    if (GoogleSignIn.getLastSignedInAccount(context) != null) {
                        googleSignInClient.signOut()
                    }
                    val intent = Intent(context, WelcomeActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                    }
                    startActivity(intent)
                }
            }
            true
        }        //menu items on click listeners


        return lay
    }                           //main code


    private fun notificationSetting(context: Context) {
//        val mDialog1 = Dialog//Add on click handlers to all switches
        val mDialog1 = Dialog(context)
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



    private fun changePassword(context: Context) {
        val mDialog1 = Dialog(context)
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

    private fun spinningMill(context: Context) {
        val mDialog1 = Dialog(context)
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

    private fun support(context: Context) {
        val mDialog1 = Dialog(context)

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
            intent.putExtra(Intent.EXTRA_EMAIL, "support@coloussustex.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "")
            intent.putExtra(Intent.EXTRA_TEXT, "")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose Email Client:"))
        }
        mDialog1.show()
    }                //code for support option in main menu

    private fun advertiseWithUs(context: Context) {
        val mDialog1 = Dialog(context)

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
            intent.putExtra(Intent.EXTRA_EMAIL, "support@coloussustex.com")
            intent.putExtra(Intent.EXTRA_SUBJECT, "")
            intent.putExtra(Intent.EXTRA_TEXT, "")
            intent.type = "message/rfc822"
            startActivity(Intent.createChooser(intent, "Choose Email Client:"))
        }
        mDialog1.show()
    }      //code for advertise with us option in main menu

}
