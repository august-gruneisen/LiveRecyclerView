# DataBindingRecyclerView
A dynamic RecyclerView that binds data for each ViewHolder to frequently changing values for its position in the list

## Use case:
Displaying a rapid stream of data that updates frequently, as in the case of displaying Bluetooth scan results in real time.

## The problem:
Scan results are generally stored in a list and displayed by a RecyclerView. The scanner often picks up a peripheral multiple times, so we check the list for duplicates before adding new items. In doing so, we lose the ability to display the latest RSSI (signal strength) of each peripheral. We can simply update the list item for a previously scanned peripheral, but the adapter still needs to rebind every time to display the new data.

## The solution:
Instead of notifying the adapter every time an item is updated, we can utilize the Data Binding Library to bind each view only once with a reference to its specific position in the list. As data updates, views observe changes to corresponding items and and update the UI instantly.
