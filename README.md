# DataBindingRecyclerView
A dynamic RecyclerView that binds data for each ViewHolder to frequently changing values for its position in a list

## Use case:
Displaying a rapid influx of data that updates frequently, as in the case of displaying Bluetooth scan results in real time.

## The problem:
Scan results are generally stored in a list and displayed by a RecyclerView. The scanner often picks up a peripheral multiple times, so we generally check the list for duplicates before adding new items. In doing so, we lose the ability to display the latest RSSI (signal strength) of each peripheral. We could update the list item for a previously scanned peripheral, but the adapter would still need to rebind every time to display the latest data.
