import api from './axios'

export const registerUser = async (userData) => {
    const response = await api.post("/register", userData);
    return response.data;
};

export const loginUser = async (loginData) => {
    const response = await api.post("/login", loginData);
    return response.data;
};