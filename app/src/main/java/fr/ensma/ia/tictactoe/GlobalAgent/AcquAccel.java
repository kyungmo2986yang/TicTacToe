package fr.ensma.ia.tictactoe.GlobalAgent;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class AcquAccel extends Thread {
    private SensorManager sensMan;
    private Sensor accelSensor;

    private MDDAccel leMdd;

    public AcquAccel(SensorManager s, MDDAccel m){
        sensMan = s;
        leMdd = m;
    }

    final SensorEventListener monEcouteurCapteur = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent event) {
            if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
                leMdd.setValeurs(event.values[0],event.values[1],event.values[2]);
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {

        }
    };

    @Override
    public void run() {
        accelSensor = sensMan.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensMan.registerListener(monEcouteurCapteur,accelSensor,sensMan.SENSOR_DELAY_GAME);
    }
}
