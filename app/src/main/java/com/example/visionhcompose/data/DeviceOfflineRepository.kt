package com.example.visionhcompose.data

import kotlinx.coroutines.flow.Flow

class DeviceOfflineRepository(private val deviceDao: DeviceDao) : DevicesRepository {

    override fun getAllDevicesStream(): Flow<List<Device>> = deviceDao.getAllDevices()
    override fun getDeviceStream(id: Int): Flow<Device?> = deviceDao.getDevice(id)
    override suspend fun insertDevice(device: Device) = deviceDao.insert(device)
    override suspend fun deleteDevice(device: Device) = deviceDao.delete(device)
    override suspend fun updateDevice(device: Device) = deviceDao.update(device)

}