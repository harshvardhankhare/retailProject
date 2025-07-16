import React, { useContext, useState, useEffect } from 'react';
import { addCategory } from '../../service/CategoryService';
import { AppContext } from '../Context/AppContext';
import toast from 'react-hot-toast';

const CategoryForm = () => {
  const { categories, setCategories } = useContext(AppContext);
  const [loading, setLoading] = useState(false);
  const [data, setData] = useState({
    name: "",
    description: "",
    bgColor: "#2c2c2c",
    imgUrl: ""
  });

  useEffect(() => {
    console.log(data);
  }, [data]);

  const onChangeHandler = (e) => {
    const { name, value } = e.target;
    setData((prevData) => ({
      ...prevData,
      [name]: value
    }));
  };

  const onSubmitHandler = async (e) => {
    e.preventDefault();
    setLoading(true);

    try {
      const res = await addCategory(data);

      if (res.status === 201) {
        setCategories([...categories, res.data]);
        toast.success("Category added successfully!");
        setData({
          name: "",
          description: "",
          bgColor: "#2c2c2c",
          imgUrl: ""
        });
      } else {
        toast.error("Error while adding category");
      }
    } catch (error) {
      console.error(error);
      toast.error("Error while adding category");
    } finally {
      setLoading(false);
    }
  };

  return (
    <div className="mx-2 mt-2">
      <div className="row">
        <div className="card col-md-12 form-container">
          <div className="card-body">
            <form onSubmit={onSubmitHandler}>
              {/* Image URL input */}
              <div className="mb-3">
                <label htmlFor="imgUrl" className="form-label">
                  Image URL <i className="bi bi-image"></i>
                </label>
                <input
                  type="text"
                  name="imgUrl"
                  id="imgUrl"
                  className="form-control"
                  placeholder="Enter image URL"
                  onChange={onChangeHandler}
                  value={data.imgUrl}
                />
              </div>

              {/* Name input */}
              <div className="mb-3">
                <label htmlFor="name" className="form-label">
                  Name <i className="bi bi-type"></i>
                </label>
                <input
                  type="text"
                  name="name"
                  id="name"
                  className="form-control"
                  placeholder="Category name"
                  onChange={onChangeHandler}
                  value={data.name}
                  required
                />
              </div>

              {/* Description */}
              <div className="mb-3">
                <label htmlFor="description" className="form-label">
                  Description <i className="bi bi-card-text"></i>
                </label>
                <textarea
                  rows="5"
                  name="description"
                  id="description"
                  className="form-control"
                  placeholder="Write content here..."
                  onChange={onChangeHandler}
                  value={data.description}
                  required
                />
              </div>

              {/* Background Color */}
              <div className="mb-3">
                <label htmlFor="bgColor" className="form-label">
                  Background Color <i className="bi bi-palette"></i>
                </label>
                <br />
                <input
                  type="color"
                  name="bgColor"
                  id="bgColor"
                  onChange={onChangeHandler}
                  value={data.bgColor}
                />
              </div>

              <button type="submit" disabled={loading} className="btn btn-primary w-100">
                {loading ? 'Saving...' : 'Save'}
              </button>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default CategoryForm;
