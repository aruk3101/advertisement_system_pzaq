import { useState, useEffect } from "react";
import { GetWorkingTimeTypes } from "services/api/WorkingTimeTypeService";

const useWorkingTimeTypes = () => {
  const [workingTimeTypes, setWorkingTimeTypes] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchItems();
  }, []);

  const fetchItems = () => {
    setLoading(true);
    GetWorkingTimeTypes().then((res) => {
      handle(res);
    });
  };

  const handle = (res) => {
    if (res.isSuccesfull) {
      setWorkingTimeTypes(res.data);
      setLoading(false);
      return;
    }
  };

  return {
    workingTimeTypes,
    loading,
    fetchItems,
  };
};

export default useWorkingTimeTypes;
