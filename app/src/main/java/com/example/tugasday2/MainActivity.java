package com.example.tugasday2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;


public class MainActivity extends AppCompatActivity {

    private EditText etSepatu, etSepatuu, etSepatuuu;
    private Button btnTotalbelanja;
    private RadioGroup btnRadiogroupp;
    private RadioButton btnSilver, btnGold, btnPlatinum;
    private TextView tvSepatu, tvSepatuu, tvSepatuuu;
    private TextView tvTittlee, tvTotall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTittlee = findViewById(R.id.tvTitlee);
        tvTotall = findViewById(R.id.tvTotall);
        etSepatu = findViewById(R.id.etSepatu);
        etSepatuu = findViewById(R.id.etSepatuu);
        etSepatuuu = findViewById(R.id.etSepatuuu);
        btnTotalbelanja = findViewById(R.id.btnTotalbelanja);
        btnRadiogroupp = findViewById(R.id.btnRadiogroupp);
        btnSilver = findViewById(R.id.btnSilver);
        btnGold = findViewById(R.id.btnGold);
        btnPlatinum = findViewById(R.id.btnPlatinum);

        btnTotalbelanja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int jordan = 2200;
                int airmax = 1700;
                int dunklow = 1400;

                String inputSepatu = etSepatu.getText() != null ? etSepatu.getText().toString() : "0";
                String inputSepatuu = etSepatuu.getText() != null ? etSepatuu.getText().toString() : "0";
                String inputSepatuuu = etSepatuuu.getText() != null ? etSepatuuu.getText().toString() : "0";

                int Sepatu = !inputSepatu.isEmpty() ? Integer.parseInt(inputSepatu) : 0;
                int Sepatuu = !inputSepatuu.isEmpty() ? Integer.parseInt(inputSepatuu) : 0;
                int Sepatuuu = !inputSepatuuu.isEmpty() ? Integer.parseInt(inputSepatuuu) : 0;

                if (Sepatu < 0 || Sepatuu < 0 || Sepatuuu < 0) {
                    tvTotall.setText("Error: Jumlah barang tidak valid.");
                    return;
                }

                int totalBelanja = (jordan * Sepatu) + (airmax * Sepatuu) + (dunklow * Sepatuuu);
                double diskonPersen = 0.1;
                double diskon = 0;
                double potongan = 0;

                if (totalBelanja >= 3000) {
                    diskon = totalBelanja * diskonPersen;
                    if (btnSilver.isChecked()) {
                        potongan = 50;
                    } else if (btnGold.isChecked()) {
                        potongan = 100;
                    } else if (btnPlatinum.isChecked()) {
                        potongan = 200;
                    }
                }else {
                    if (btnSilver.isChecked()) {
                        potongan = 50;
                    } else if (btnGold.isChecked()) {
                        potongan = 100;
                    } else if (btnPlatinum.isChecked()) {
                        potongan = 200;
                    }
                }

                double totalAkhir = totalBelanja - diskon - potongan;

                StringBuilder notaBuilder = new StringBuilder();
                notaBuilder.append("===== NOTA PEMBELIAN =====\n");
                notaBuilder.append("Nama Barang:\n");
                notaBuilder.append("Jordan: " + Sepatu + " pasang\n");
                notaBuilder.append("Air Max: " + Sepatuu + " pasang\n");
                notaBuilder.append("Dunk Low: " + Sepatuuu + " pasang\n\n");
                notaBuilder.append("Total Harga Barang: Rp " + totalBelanja + "\n");

                notaBuilder.append("Diskon: Rp " + diskon + "\n");
                notaBuilder.append("Potongan: Rp " + potongan + "\n\n");
                notaBuilder.append("Total Akhir: Rp " + totalAkhir + "\n");

                tvTotall.setText(notaBuilder.toString());
            }
        });
    }
}