package com.abituriyentuz.abituriyent

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.abituriyentuz.abituriyent.Models.MyModel
import com.abituriyentuz.abituriyent.databinding.FragmentLoginBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.*
import kotlin.system.exitProcess

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
var visible = 0

class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var RC_SIGN_IN = 1
    lateinit var auth: FirebaseAuth
    lateinit var googleSignInClient: GoogleSignInClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(context, gso)

        auth = FirebaseAuth.getInstance()

    }

    lateinit var list: ArrayList<MyModel>
    lateinit var binding: FragmentLoginBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(LayoutInflater.from(context))

        //animatsiya

        val anim = AnimationUtils.loadAnimation(context, R.anim.left_anim)
        val anim2 = AnimationUtils.loadAnimation(context, R.anim.two_card_anim)
        val anim3 = AnimationUtils.loadAnimation(context, R.anim.left_down_anim)
        val anim4 = AnimationUtils.loadAnimation(context, R.anim.bottom_anim)
        binding.welcome.startAnimation(anim)

        anim.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.card1.visibility = View.VISIBLE
                binding.card2.visibility = View.VISIBLE
                binding.card1.startAnimation(anim2)
                binding.card2.startAnimation(anim2)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })

        anim2.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {

            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.liner1.startAnimation(anim3)
                binding.liner2.startAnimation(anim3)
                binding.txtStudent.startAnimation(anim3)
                binding.txtTeacher.startAnimation(anim3)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })

        anim3.setAnimationListener(object : Animation.AnimationListener{
            override fun onAnimationStart(p0: Animation?) {
            }

            override fun onAnimationEnd(p0: Animation?) {
                binding.card5.startAnimation(anim4)
            }

            override fun onAnimationRepeat(p0: Animation?) {
            }
        })

            //animatsiya end

        binding.cardOquvchi.setOnClickListener {
            binding.liner1.setBackgroundResource(R.drawable.back_item)
            binding.liner2.setBackgroundResource(R.drawable.back_item_null)
            binding.card4.visibility = View.INVISIBLE
            binding.txtFanlar.visibility = View.INVISIBLE
            binding.txtStudent.setTextColor(Color.parseColor("#FFFFFF"))
            binding.txtTeacher.setTextColor(Color.parseColor("#808080"))
            visible = 0
        }

        binding.cardOqituvchi.setOnClickListener {
            binding.card4.visibility = View.VISIBLE
            binding.liner1.setBackgroundResource(R.drawable.back_item_null)
            binding.liner2.setBackgroundResource(R.drawable.back_item)
            binding.txtFanlar.visibility = View.VISIBLE
            binding.txtTeacher.setTextColor(Color.parseColor("#FFFFFF"))
            binding.txtStudent.setTextColor(Color.parseColor("#808080"))
            visible = 1
        }

        binding.card5.setOnClickListener {
            signIn()
        }



        return binding.root

    }


    private fun signIn() {
        val signInIntent = googleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)


        if (visible == 0){
            findNavController().navigate(R.id.oquvchiMainFragment)
        }
        else if (visible == 1){
            findNavController().navigate(R.id.ustozMainFragment)
        }
        // exitProcess(1) for destroy
    }


    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
        // Sign in success, update UI with the signed-in user's information
        Log.d(TAG, "signInWithCredential:success")
        val user = auth.currentUser
//                    updateUI(user)
        Toast.makeText(context, "${user?.email}", Toast.LENGTH_SHORT).show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e)
            }
        }
    }


}       