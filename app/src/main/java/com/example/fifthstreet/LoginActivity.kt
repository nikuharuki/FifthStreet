package com.example.fifthstreet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.example.fifthstreet.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        emailFocusListener()
        passwordFocusListener()

        //sign in button
        binding.signInBtn.setOnClickListener {
            val validEmail = validEmail() == null
            val validPassword = validPassword() == null

            if (validEmail && validPassword) {
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("email", binding.emailEt.text.toString())
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()

                startActivity(intent)
                //finish()

            }else{
                if (binding.emailEt.text.toString().isBlank()){
                    binding.emailContainer.helperText = "Required"
                }
                if (binding.passwordEt.text.toString().isBlank()){
                    binding.passwordContainer.helperText = "Required"
                }
                Toast.makeText(this, "Invalid login credentials", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(intent)
        }
    }


    //email validation
    private fun emailFocusListener() {
        binding.emailEt.setOnFocusChangeListener { _, focused ->
            if (!focused) {
                binding.emailContainer.helperText = validEmail()
            }
        }
    }

    private fun validEmail(): String? {
        val email = binding.emailEt.text.toString()
//        i figured mas maganda if pag clinick yung signInBtn nalang mag ttriger yung isBlank
//        if (email.isBlank()) {
//            return "Required"
//        }
        if (!email.endsWith("@iacademy.edu.ph")){
            return "Use iAcademy Email"
        }
    return null
    }

    //password validation
    private fun passwordFocusListener() {
        binding.passwordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                binding.passwordContainer.helperText = validPassword()
            }
        })
    }


    private fun validPassword(): String? {
        val password = binding.passwordEt.text.toString()
//        if (password.isBlank()) {
//            return "Required"
//        }
        if (password.length < 8){
            return "Minimum 8 Character Password"
        }
        if (!password.contains(Regex("[0-9]"))){
            return "Password must contain a number"
        }
        if (!password.contains(Regex("[A-Z]"))){
            return "Password must contain a capital letter"
        }
        if (!password.contains(Regex("[a-z]"))){
            return "Password must contain a small letter"
        }
        return null
    }
}