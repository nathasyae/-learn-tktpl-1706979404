package id.ac.ui.cs.mobileprogramming.nathasyaeliora.myapplication

class WifiReceiver {
    @Override
    public void onReceive(Context context, Intent intent){
        results = wifiManager.getScanResults();
        unregisterReceiver(this);

        for (ScanResult scanResult: results){
            arrayList.add(ScanResult.SSID);
            adapter.notifyDataSetChanged();
        }
}