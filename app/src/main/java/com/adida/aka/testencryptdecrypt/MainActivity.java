package com.adida.aka.testencryptdecrypt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.cert.CertificateException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class MainActivity extends AppCompatActivity {
    EditText mEdtString, mEdtEncrypt, mEdtDecrypt;
    private KeyHelper mKeyHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        try {
            mKeyHelper = new KeyHelper(this);
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        } catch (CertificateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void initView() {
        mEdtString = (EditText) findViewById(R.id.edt_input_string);
        mEdtEncrypt = (EditText) findViewById(R.id.edt_encrypt);
        mEdtDecrypt = (EditText) findViewById(R.id.edt_decrypt);
    }
    public void onEncrypt(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, UnsupportedEncodingException {
        String s = mKeyHelper.encrypt(MainActivity.this, mEdtString.getText().toString());
        mEdtEncrypt.setText(s);
    }

    public void onDecrypt(View view) throws NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, NoSuchProviderException, UnsupportedEncodingException {
        String s = mKeyHelper.decrypt(MainActivity.this, mEdtEncrypt.getText().toString());
        mEdtDecrypt.setText(s);
    }
}
