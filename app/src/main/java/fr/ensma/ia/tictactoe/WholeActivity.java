package fr.ensma.ia.tictactoe;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import fr.ensma.ia.tictactoe.GlobalAgent.GamePresentation;

public class WholeActivity extends AppCompatActivity {
    private static GamePresentation presentation;
    private static boolean  configured, childExists;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        presentation = new GamePresentation();
        configured = false; childExists = false;
        configurerBoutons();
    }

    public static GamePresentation getPresentation(){
        return presentation;
    }

    private void configurerBoutons() {
        final Button playButton = (Button) findViewById(R.id.playButton);
        Button counterButton = (Button) findViewById(R.id.counter);

        playButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (configured && !childExists) {
                    childExists = true;
                    startActivity(new Intent(WholeActivity.this, MainActivity.class));
                } else {
                    if (childExists) {
                        presentation.updateReset();
                        startActivity(new Intent(WholeActivity.this, MainActivity.class));
                    }
                    if (!configured) {
                        Toast.makeText(getApplicationContext(), getString(R.string.geterror), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        counterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NumberPickerDialog newFragment = new NumberPickerDialog();
                newFragment.show(getSupportFragmentManager(), "DatePicker");
            }
        });
    }

    @Override
    public boolean onNavigateUpFromChild(Activity child) {
        presentation.updateKill();
        return super.onNavigateUpFromChild(child);
    }

    public static class NumberPickerDialog extends DialogFragment implements NumberPicker.OnValueChangeListener {

        public NumberPickerDialog(){

        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final NumberPicker numberPicker = new NumberPicker(getActivity());
            numberPicker.setMinValue(1);
            numberPicker.setMaxValue(30);
            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("Time Counter Configuration");
            builder.setMessage("Choose a limit of time : ");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which){
                    onValueChange(numberPicker,numberPicker.getValue(), numberPicker.getValue());
                    presentation.updateTimer(numberPicker.getValue());
                    configured = true;
                }
            });

            builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getActivity(), "Action Cancelled", Toast.LENGTH_SHORT).show();
                }
            });

            builder.setView(numberPicker);
            return builder.create();
        }

        @Override
        public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
            Toast.makeText(getActivity(), "selected number " + picker.getValue(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public String toString() {
        return "CalendarF";
    }
}
