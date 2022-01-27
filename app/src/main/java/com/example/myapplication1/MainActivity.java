package com.example.myapplication1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = this.getApplicationContext();
        ActivityManager mgr = (ActivityManager)context.getSystemService(ACTIVITY_SERVICE);
        List<ActivityManager.RunningAppProcessInfo> processes = mgr.getRunningAppProcesses();
        Log.e("DEBUG", "Running processes:");
        //for(Iterator i = processes.iterator(); i.hasNext(); )
        //{
            //ActivityManager.RunningAppProcessInfo p = (ActivityManager.RunningAppProcessInfo)i.next();
           // Log.e("DEBUG", "  process name: "+p.processName);
          //  Log.e("DEBUG", "     pid: "+p.pid);
            int[] pids = {15840};

           // pids[0] = p.pid;
            android.os.Debug.MemoryInfo[] MI = mgr.getProcessMemoryInfo(pids);

        //Log.e("DEBUG","     PROCESSNAME: " + pids[0].);
            Log.e("memory","     dalvik private: " + MI[0].dalvikPrivateDirty);
            Log.e("memory","     dalvik shared: " + MI[0].dalvikSharedDirty);
            Log.e("memory","     dalvik pss: " + MI[0].dalvikPss);
            Log.e("memory","     native private: " + MI[0].nativePrivateDirty);
            Log.e("memory","     native shared: " + MI[0].nativeSharedDirty);
            Log.e("memory","     native pss: " + MI[0].nativePss);
            Log.e("memory","     other private: " + MI[0].otherPrivateDirty);
            Log.e("memory","     other shared: " + MI[0].otherSharedDirty);
            Log.e("memory","     other pss: " + MI[0].otherPss);

            Log.e("memory","     total private dirty memory (KB): " + MI[0].getTotalPrivateDirty());
            Log.e("memory","     total shared (KB): " + MI[0].getTotalSharedDirty());
            Log.e("memory","     total pss: " + MI[0].getTotalPss());
        //}

   //-----------------------------------------------------------------------
      //  int pid = android.os.Process.;
       // Log.e("Hello","     boys: " + pid);

        ShellExecuter exe = new ShellExecuter();

        String command= "ls -l /" ;
       // command = input.getText().toString();

        String outp = exe.Executer(command);
        //out.setText(outp);
        Log.d("Out", outp);


    }
}