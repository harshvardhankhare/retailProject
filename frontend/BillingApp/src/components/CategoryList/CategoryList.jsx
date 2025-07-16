import "./CategoryList.css";
import React, { useContext, useState } from "react";
import { AppContext } from "../Context/AppContext";
import { deleteCategory } from "../../service/CategoryService";
import toast from "react-hot-toast";

const CategoryList = () => {
  const { categories, setCategories } = useContext(AppContext);
  const [searchTerm, setSearchTerm] = useState("");

  const filteredCategories = categories.filter((category) =>
    category.name?.toLowerCase().includes(searchTerm.toLowerCase())
  );

  const deleteByCategoryId = async (categoryId) => {
    try {
      const res = await deleteCategory(categoryId);
      if (res.status === 200) {
        const updatedCategories = categories.filter(
          (category) => category.categoryId !== categoryId
        );
        setCategories(updatedCategories);
        toast.success("Category Deleted");
      } else {
        toast.error("Unable to delete the category");
      }
    } catch (error) {
      console.error("Delete Error:", error);
      toast.error("Something went wrong while deleting");
    }
  };

  return (
    <div
      className="category-list-container"
      style={{ height: "100vh", overflowY: "auto", overflowX: "hidden" }}
    >
      {/* Search Input */}
      <div className="row pe-2">
        <div className="input-group mb-3">
          <input
            type="text"
            name="keyword"
            id="keyword"
            placeholder="Search By Keyword"
            className="form-control"
            onChange={(e) => setSearchTerm(e.target.value)}
            value={searchTerm}
          />
          <span className="input-group-text bg-warning">
            <i className="bi bi-search"></i>
          </span>
        </div>
      </div>

      {/* Category Cards */}
      <div className="row pe-2">
        {filteredCategories.map((category) => (
          <div key={category.categoryId} className="col-12 mb-3">
            <div className="card p-3" style={{ backgroundColor: category.bgColor }}>
              <div className="d-flex align-items-center">
                <div style={{ marginRight: "15px" }}>
                  <img src={category.imgUrl} alt="" className="category-img" />
                </div>
                <div className="flex-grow-1">
                  <h5 className="mb-1 text-white">{category.name}</h5>
                  <p className="mb-0 text-white">{category.items} items</p>
                </div>
                <div>
                  <button
                    className="btn btn-danger btn-sm"
                    onClick={() => deleteByCategoryId(category.categoryId)}
                  >
                    <i className="bi bi-trash"></i>
                  </button>
                </div>
              </div>
            </div>
          </div>
        ))}

        {/* No Results */}
        {filteredCategories.length === 0 && (
          <div className="col-12 text-center text-white mt-4">
            No categories found.
          </div>
        )}
      </div>
    </div>
  );
};

export default CategoryList;
