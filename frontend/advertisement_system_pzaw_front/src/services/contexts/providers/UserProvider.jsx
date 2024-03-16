import { useEffect, useMemo, useState } from "react";
import UserContext from "services/contexts/contexts/UserContext";
import { Info } from "services/api/UserService";
import { toast } from "react-toastify";
import SpinnerView from "components/common/SpinnerView/SpinnerView";

const UserProvider = ({ children }) => {
  const [user, setUser] = useState(null);
  const [isLoading, setIsLoading] = useState(true);

  useEffect(() => {
    setIsLoading(true);
    Info().then((res) => {
      if (!res.isSuccesfull) {
        toast.error(res.message, {
          position: toast.POSITION.BOTTOM_RIGHT,
        });
        return;
      }
      setUser(res.data);
      setIsLoading(false);
    });
  }, []);

  const contextValue = useMemo(
    () => ({
      user,
    }),
    [user]
  );

  console.log(isLoading);
  console.log(user);

  return (
    <SpinnerView isLoading={isLoading}>
      <UserContext.Provider value={contextValue}>
        {children}
      </UserContext.Provider>
    </SpinnerView>
  );
};

export default UserProvider;
