package com.example.business.concretes
import com.example.business.abstracts.IUserService
import com.example.dataaccess.abstracts.IUserDao
import com.example.dataaccess.concretes.UserDao
import com.example.entities.UserEntity

class UserService(private val iuserDao: IUserDao) : IUserService {

    override fun getAll(): List<UserEntity> {
        return iuserDao.getAll()
    }

    override fun create(userEntity: UserEntity) {
        iuserDao.create(userEntity)
    }

    override fun delete(id: Int) {
        iuserDao.delete(id)
    }
}
