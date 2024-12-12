# Weather Data Processing Pipeline Kata

## Task Description

Create a real-time weather data processing pipeline using Kotlin coroutines and flows. This kata simulates receiving weather data from multiple sensors and processes this data to provide insights and alerts.

## Requirements

### 1. Data Source Simulation

- Simulate multiple weather sensors using `Flow`.
- Each sensor should emit data asynchronously at different intervals.
- Data points should include:
  - Sensor ID
  - Timestamp
  - Measurement type (e.g., temperature, humidity, wind speed)
  - Value

### 2. Processing Pipeline

- Implement a processing pipeline using flow operators:
  - Filter out invalid data (e.g., negative temperatures, humidity > 100%).
  - Transform raw sensor readings into a standardized format.
  - Aggregate data into rolling averages over a specified time window (e.g., last 10 seconds).

### 3. Alert System

- Create an alert system using `Flow` that triggers when:
  - Temperature exceeds a threshold (e.g., 40°C).
  - Sudden changes in wind speed are detected (e.g., >20 km/h within 5 seconds).
- Emit alerts downstream as part of the flow.

### 4. Concurrency

- Ensure the data processing pipeline runs concurrently without blocking the main thread.
- Use appropriate coroutine contexts and operators like `flowOn` to manage thread usage.

### 5. Output

- Collect and print the final processed data and alerts in real-time.
- Preserve the order of events in the output.

## Bonus Challenges

- Implement error handling to manage exceptions during data processing gracefully.
- Add a feature to dynamically adjust alert thresholds based on user input.
- Simulate network delays or sensor failures and ensure pipeline resilience.

## Example Output

```
SensorData(sensorId=1, timestamp=2024-12-12T11:00:01Z, type="Temperature", value=35.0)
SensorData(sensorId=2, timestamp=2024-12-12T11:00:02Z, type="Wind Speed", value=15.0)
ALERT: High temperature detected! Sensor ID: 1, Value: 42.0°C
ProcessedData(sensorId=1, avgTemperature=33.5°C, avgHumidity=60%)
```

## External API Providers

For those looking to integrate real sensor data, consider these free, open-source sensor APIs:

1. **BGS Sensor Data Service**: Environmental sensor data from the British Geological Survey.
   - API: `https://sensors.bgs.ac.uk/FROST-Server/v1.1`

2. **Sensor.Community**: Global network of citizen-driven air quality sensors.
   - API: `https://data.sensor.community/airrohr/v1/sensor/{SENSOR_ID}/`

3. **OPEN·SENSOR·WEB**: Aggregates environmental data from various public sources.

4. **IoT-Ignite Cloud API**: Provides access to IoT device sensor data.
   - API: `https://api.ardich.com/device/{DEVICE-ID}/sensor-data`

5. **Generic Sensor API**: Browser-based API for accessing device sensors.

These APIs can be used to fetch real-time sensor data, adding authenticity to your weather data processing pipeline.

## Getting Started

1. Set up a new Kotlin project with coroutines support.
2. Implement the data source simulation using `Flow`.
3. Create the processing pipeline using flow operators.
4. Implement the alert system within the pipeline.
5. Ensure concurrent execution and proper thread management.
6. Test your implementation with various scenarios.

Good luck, and happy coding!