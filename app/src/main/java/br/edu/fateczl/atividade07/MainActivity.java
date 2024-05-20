package br.edu.fateczl.atividade07;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText clienteEditText, numContaEditText, saldoEditText, valorEditText;
    private RadioGroup radioGroup;
    private ContaBancaria contaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clienteEditText = findViewById(R.id.clienteEditText);
        numContaEditText = findViewById(R.id.numContaEditText);
        saldoEditText = findViewById(R.id.saldoEditText);
        valorEditText = findViewById(R.id.valorEditText);
        radioGroup = findViewById(R.id.radioGroup);
    }

    public void criarConta(View view) {
        String cliente = clienteEditText.getText().toString();
        int numConta = Integer.parseInt(numContaEditText.getText().toString());
        float saldo = Float.parseFloat(saldoEditText.getText().toString());

        int radioButtonId = radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(radioButtonId);
        String tipoConta = radioButton.getText().toString();

        if (tipoConta.equals("Conta Poupança")) {
            contaSelecionada = new ContaPoupanca(cliente, numConta, saldo, 1);
        } else if (tipoConta.equals("Conta Especial")) {
            float limite = 1000;
            contaSelecionada = new ContaEspecial(cliente, numConta, saldo, limite);
        }

        Toast.makeText(this, "Conta criada com sucesso!", Toast.LENGTH_SHORT).show();
    }

    public void sacar(View view) {
        if (contaSelecionada != null) {
            float valor = Float.parseFloat(valorEditText.getText().toString());
            contaSelecionada.sacar(valor);
        } else {
            Toast.makeText(this, "Crie uma conta primeiro.", Toast.LENGTH_SHORT).show();
        }
    }

    public void depositar(View view) {
        if (contaSelecionada != null) {
            float valor = Float.parseFloat(valorEditText.getText().toString());
            contaSelecionada.depositar(valor);
        } else {
            Toast.makeText(this, "Crie uma conta primeiro.", Toast.LENGTH_SHORT).show();
        }
    }
}
