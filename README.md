# DataBindingRecyclerView
A dynamic RecyclerView that binds each ViewHolder to the data for its specific position in the list

## Use case:
Displaying a rapid influx of data that updates frequently, as in the case of displaying Bluetooth Scan Results in real time.

## The problem:
Scan results are generally stored in a list displayed by an ordinary RecyclerView. The scanner often picks up the same peripheral multiple times, so we generally check the list for duplicates before adding new items. In doing so, we miss out on the ability to display the RSSI value (signal strength) of the latest scan for each peripheral.
