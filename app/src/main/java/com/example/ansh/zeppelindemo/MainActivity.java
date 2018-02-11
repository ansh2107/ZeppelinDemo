package com.example.ansh.zeppelindemo;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ansh.zeppelindemo.data.model.RestResponseInfo;
import com.example.ansh.zeppelindemo.data.remote.APIService;
import com.example.ansh.zeppelindemo.data.remote.APIUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView tv_material_list;
    private APIService mAPIService;

    private EditText lineNumberEt;
    private EditText temperatureEt;
    private EditText pressureEt;
    private EditText humidityEt;
    private EditText timeEt;
    private EditText materialEt;

    private Button mAdd;
    private Button mSubmit;

    private String[] mArrayListMaterial;

    private int index = 0;
    private Context context;

    private String concat= "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;
        init();

        /**
         * This is method to add the materials in the textview on the
         * android screen and also to populate the arraylist of materials for the
         * database post request.
         */

        mAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mArrayListMaterial[index++] = materialEt.getText().toString();

                concat = concat + " " +materialEt.getText().toString();
                tv_material_list.setText(concat);
            }
        });

        /**
         * This is the method for onclick event of check output button.
         */
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String line_no = lineNumberEt.getText().toString().trim();
                String temperature = temperatureEt.getText().toString().trim();
                String pressure = pressureEt.getText().toString().trim();
                String humidity = humidityEt.getText().toString().trim();
                String time = timeEt.getText().toString().trim();

                if (    !TextUtils.isEmpty(line_no) &&
                        !TextUtils.isEmpty(temperature) &&
                        !TextUtils.isEmpty(pressure) &&
                        !TextUtils.isEmpty(humidity) &&
                        !TextUtils.isEmpty(time)) {

                    sendPost(line_no,temperature,pressure,humidity,time,mArrayListMaterial);
                }

                tv_material_list.setText("");
                materialEt.setText("");
                lineNumberEt.setText("");
                temperatureEt.setText("");
                pressureEt.setText("");
                humidityEt.setText("");
                timeEt.setText("");
                index = 0;
                concat = "";



            }
        });
    }

    /**
     * This method initialises the ui elements for the app.
     */
    public void init()
    {
             lineNumberEt = (EditText) findViewById(R.id.et_line_number);
             temperatureEt = (EditText) findViewById(R.id.et_temperature);
             pressureEt = (EditText) findViewById(R.id.et_pressure);
             humidityEt = (EditText) findViewById(R.id.et_humidity);
             timeEt = (EditText) findViewById(R.id.et_time);
             materialEt = (EditText) findViewById(R.id.et_material);

             mSubmit = (Button) findViewById(R.id.btn_submit);
             mAdd = (Button) findViewById(R.id.btn_add);

             tv_material_list = (TextView) findViewById(R.id.arraylist_material);

             mArrayListMaterial = new String[1000];


             mAPIService = APIUtils.getAPIService();


    }

    /**
     *
     * @param line_no - Line number for which the process is going on.
     * @param temperature - Temperature required for the process line.
     * @param pressure - Pressure required for the process line.
     * @param humidity - Humidity required for the process line.
     * @param time - Time required for the process line.
     * @param material_list - List of input materials to the input line process.
     */
    public void sendPost(String line_no,
                         String temperature ,
                         String pressure ,
                         String humidity ,
                         String time,
                         String[] material_list) {

        mAPIService.getProcessInfo(line_no,temperature,pressure,humidity,time,material_list).enqueue(new Callback<RestResponseInfo>() {
            @Override
            public void onResponse(Call<RestResponseInfo> call, Response<RestResponseInfo> response) {

                /**
                 * Callback for the succes response from the server.
                 */
                if(response.isSuccessful()) {
                    //showResponse(response.body().toString());
                    if(response.body().getSuccess().size() == 0)
                        Toast.makeText(context,"Entry doesn't exist.",Toast.LENGTH_LONG).show();
                    else
                        showOutputDialogue(response);
                }
            }

            @Override
            public void onFailure(Call<RestResponseInfo> call, Throwable t) {
                Toast.makeText(context,"Not a valid entry.",Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * This methid opens a dialogue box for the output data.
     *
     * @param response - Succesful response from the server for entered query.
     */
    private void showOutputDialogue(Response<RestResponseInfo> response) {

        // custom dialog
        final Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialogue_custom);
        dialog.setTitle("Output");

        // set the custom dialog components - text
        TextView text_grade = (TextView) dialog.findViewById(R.id.tv_grade);
        TextView text_weight = (TextView) dialog.findViewById(R.id.tv_weight);


        text_grade.setText("Grade :" + " "  + response.body().getSuccess().get(0).getGradeOutput());
        text_weight.setText("Weight :" + " "  +response.body().getSuccess().get(0).getWeight());

        dialog.show();
    }


}
