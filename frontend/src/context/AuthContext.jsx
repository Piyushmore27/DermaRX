import { createContext, useContext, useState } from "react";

const AuthContext = createContext(null);

export const AuthProvider = ({ children }) => {
    
    const [user, setUser] = useState(null);
    const [isLogin, setIsLogin] = useState(false);
   

    const login = (userData) => {
        setUser(userData);
        setIsLogin(true);
    };

    const logout = () => {
        setUser(null);
        setIsLogin(false);
    }

    return (
        <AuthContext.Provider value={{ user, isLogin, login, logout}}>
            {children}
        </AuthContext.Provider>
    );
};

export const useAuth = () => {
    const context =  useContext(AuthContext);

    if(!context) {
        throw new Error("useAuth must be used inside AuthProvider");
    }

    return context;
};