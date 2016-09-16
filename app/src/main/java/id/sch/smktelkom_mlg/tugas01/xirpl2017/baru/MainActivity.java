package id.sch.smktelkom_mlg.tugas01.xirpl2017.baru;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etNama, etNomerTelepon, etJumlahPenumpangDewasa, etJumlahPenumpangAnak;
    Button bPesan;
    RadioGroup rgkereta;
    RadioButton rbme, rbmalaba, rbgajayana;
    CheckBox cbdua, cbtiga, cblebih;
    Spinner spRute;
    TextView tvhasil, tvNama, tvtelp, tvdewasa, tvanak;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNama = (EditText) findViewById(R.id.nama);
        etNomerTelepon = (EditText) findViewById(R.id.telp);
        etJumlahPenumpangDewasa = (EditText) findViewById(R.id.jpd);
        etJumlahPenumpangAnak = (EditText) findViewById(R.id.jpa);
        bPesan = (Button) findViewById(R.id.pesan);
        rgkereta = (RadioGroup) findViewById(R.id.rgkereta);
        rbme = (RadioButton) findViewById(R.id.me);
        rbmalaba = (RadioButton) findViewById(R.id.malabar);
        rbgajayana = (RadioButton) findViewById(R.id.gajayana);
        cbdua = (CheckBox) findViewById(R.id.cbdua);
        cbtiga = (CheckBox) findViewById(R.id.cbtiga);
        cblebih = (CheckBox) findViewById(R.id.cblebih);
        spRute = (Spinner) findViewById(R.id.spinner);
        tvhasil = (TextView) findViewById(R.id.tutup);
        tvNama = (TextView) findViewById(R.id.tvnama);
        tvdewasa = (TextView) findViewById(R.id.tvdewasa);
        tvanak = (TextView) findViewById(R.id.tvanak);
        tvtelp = (TextView) findViewById(R.id.tvtelp);


        bPesan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
    }

    private void doProcess() {
        if (isValid()) {
            String nama = etNama.getText().toString();
            String telp = etNomerTelepon.getText().toString();
            tvtelp.setText("No. Telp : " + telp);
            tvNama.setText("Nama : " + nama);
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = etNama.getText().toString();
        String telp = etNomerTelepon.getText().toString();

        if (nama.isEmpty()) {
            etNama.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            etNama.setError("Nama minimal 3 karakter");
            valid = false;
        } else {
            etNama.setError(null);
        }

        if (telp.isEmpty()) {
            etNomerTelepon.setError("Nomor Telepon belum diisi");
        } else if (telp.length() < 9) {
            etNomerTelepon.setError("Nomor Telepon tidak valid (kurang dari 10 digit)");
            valid = false;
        } else {
            etNomerTelepon.setError(null);
        }

        return valid;
    }

}
