BroadcastReceiver wifiReceiver = new BroadcastReceiver(){
    @Override
    public void onReceive(Context context,Intent intent){
        results=wifiManager.getScanResults();
        unregisterReceiver(this);

        for(ScanResult scanResult : results){
            arrayList.add(ScanResult.SSID);
            adapter.notifyDataSetChanged();
        }
    }
}