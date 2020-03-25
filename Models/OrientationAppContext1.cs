using System;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Metadata;

namespace LoginApi
{
    public partial class OrientationAppDBContext : DbContext
    {
        public OrientationAppDBContext()
        {
        }

        public OrientationAppDBContext(DbContextOptions<OrientationAppDBContext> options)
            : base(options)
        {
        }

        public virtual DbSet<Assets> Assets { get; set; }
        public virtual DbSet<Categories> Categories { get; set; }
        public virtual DbSet<DevCenter> DevCenter { get; set; }
        public virtual DbSet<DevCenterUsers> DevCenterUsers { get; set; }
        public virtual DbSet<HibernateSequence> HibernateSequence { get; set; }
        public virtual DbSet<Role> Role { get; set; }
        public virtual DbSet<RoleSteps> RoleSteps { get; set; }
        public virtual DbSet<Steps> Steps { get; set; }
        public virtual DbSet<StepsUser> StepsUser { get; set; }
        public virtual DbSet<User> User { get; set; }
        public virtual DbSet<UserAssignedEquipment> UserAssignedEquipment { get; set; }
        public virtual DbSet<UserStep> UserStep { get; set; }
        public virtual DbSet<UserUserSteps> UserUserSteps { get; set; }
        public virtual DbSet<UserData> Userdata { get; set; }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
#warning To protect potentially sensitive information in your connection string, you should move it out of source code. See http://go.microsoft.com/fwlink/?LinkId=723263 for guidance on storing connection strings.
                optionsBuilder.UseMySql("DefaultConnection", x => x.ServerVersion("8.0.17-mysql"));
                //server=agssqlw02;port=3306;database=orientationapp;user=orientationapp;password=9MHCnt76dy3RmNmp
            }
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Assets>(entity =>
            {
                entity.HasKey(e => e.AssetId)
                    .HasName("PRIMARY");

                entity.ToTable("assets");

                entity.HasIndex(e => e.Email)
                    .HasName("FKo2lwyid65h3otgyi56gnfr14");

                entity.Property(e => e.AssetId)
                    .HasColumnName("asset_id")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Email)
                    .HasColumnName("email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Equipment)
                    .HasColumnName("equipment")
                    .HasColumnType("int(11)");

                entity.HasOne(d => d.EmailNavigation)
                    .WithMany(p => p.Assets)
                    .HasForeignKey(d => d.Email)
                    .HasConstraintName("FKo2lwyid65h3otgyi56gnfr14");
            });

            modelBuilder.Entity<Categories>(entity =>
            {
                entity.HasKey(e => e.CategoryId)
                    .HasName("PRIMARY");

                entity.ToTable("categories");

                entity.HasIndex(e => e.Category)
                    .HasName("UK_5ky4frjmcobbiayt5jyx53mff")
                    .IsUnique();

                entity.Property(e => e.CategoryId)
                    .HasColumnName("category_id")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Category)
                    .IsRequired()
                    .HasColumnName("category")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");
            });

            modelBuilder.Entity<DevCenter>(entity =>
            {
                entity.HasKey(e => e.Location)
                    .HasName("PRIMARY");

                entity.ToTable("dev_center");

                entity.Property(e => e.Location)
                    .HasColumnName("location")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.HrRep)
                    .IsRequired()
                    .HasColumnName("hr_rep")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");
            });

            modelBuilder.Entity<DevCenterUsers>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("dev_center_users");

                entity.HasIndex(e => e.DevCenterLocation)
                    .HasName("FKdrqrngjcg2lmwr9y3cnly5vay");

                entity.HasIndex(e => e.UsersEmail)
                    .HasName("UK_ljsslcekg4iu1mxhrwfa4h22e")
                    .IsUnique();

                entity.Property(e => e.DevCenterLocation)
                    .IsRequired()
                    .HasColumnName("dev_center_location")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.UsersEmail)
                    .IsRequired()
                    .HasColumnName("users_email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.HasOne(d => d.DevCenterLocationNavigation)
                    .WithMany(p => p.DevCenterUsers)
                    .HasForeignKey(d => d.DevCenterLocation)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKdrqrngjcg2lmwr9y3cnly5vay");

                entity.HasOne(d => d.UsersEmailNavigation)
                    .WithOne(p => p.DevCenterUsers)
                    .HasForeignKey<DevCenterUsers>(d => d.UsersEmail)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKeiau47a8acrtrl0utai6p1og8");
            });

            modelBuilder.Entity<HibernateSequence>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("hibernate_sequence");

                entity.Property(e => e.NextVal)
                    .HasColumnName("next_val")
                    .HasColumnType("bigint(20)");
            });

            modelBuilder.Entity<Role>(entity =>
            {
                entity.HasKey(e => e.Role1)
                    .HasName("PRIMARY");

                entity.ToTable("role");

                entity.Property(e => e.Role1)
                    .HasColumnName("role")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");
            });

            modelBuilder.Entity<RoleSteps>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("role_steps");

                entity.HasIndex(e => e.RoleRole)
                    .HasName("FKecpsdgg1fpbn850jqgqci8dvx");

                entity.HasIndex(e => e.StepsStep)
                    .HasName("UK_1ndg6ndyv38oal9x3nuw3unej")
                    .IsUnique();

                entity.Property(e => e.RoleRole)
                    .IsRequired()
                    .HasColumnName("role_role")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.StepsStep)
                    .HasColumnName("steps_step")
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.RoleRoleNavigation)
                    .WithMany(p => p.RoleSteps)
                    .HasForeignKey(d => d.RoleRole)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKecpsdgg1fpbn850jqgqci8dvx");

                entity.HasOne(d => d.StepsStepNavigation)
                    .WithOne(p => p.RoleSteps)
                    .HasForeignKey<RoleSteps>(d => d.StepsStep)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK3bupak9vub0qpivjetea4utpj");
            });

            modelBuilder.Entity<Steps>(entity =>
            {
                entity.HasKey(e => e.Step)
                    .HasName("PRIMARY");

                entity.ToTable("steps");

                entity.HasIndex(e => e.Category)
                    .HasName("FKhwmi7og283sno4lh75p0gtyba");

                entity.HasIndex(e => e.StepNum)
                    .HasName("FK3g7j879ds80y9j55yg932tcup");

                entity.Property(e => e.Step)
                    .HasColumnName("step")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Category)
                    .IsRequired()
                    .HasColumnName("category")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Description)
                    .HasColumnName("description")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.StepNum)
                    .HasColumnName("step_num")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Title)
                    .IsRequired()
                    .HasColumnName("title")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.HasOne(d => d.CategoryNavigation)
                    .WithMany(p => p.Steps)
                    .HasPrincipalKey(p => p.Category)
                    .HasForeignKey(d => d.Category)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKhwmi7og283sno4lh75p0gtyba");

                entity.HasOne(d => d.StepNumNavigation)
                    .WithMany(p => p.Steps)
                    .HasForeignKey(d => d.StepNum)
                    .HasConstraintName("FK3g7j879ds80y9j55yg932tcup");
            });

            modelBuilder.Entity<StepsUser>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("steps_user");

                entity.HasIndex(e => e.StepStep)
                    .HasName("FKgtwmvs0hd03e314xoh5t8poc6");

                entity.HasIndex(e => e.UserUserStepId)
                    .HasName("UK_p4qh9sqlpdqcbt0m4c8b6va5x")
                    .IsUnique();

                entity.Property(e => e.StepStep)
                    .HasColumnName("step_step")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.UserUserStepId)
                    .HasColumnName("user_user_step_id")
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.StepStepNavigation)
                    .WithMany(p => p.StepsUser)
                    .HasForeignKey(d => d.StepStep)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKgtwmvs0hd03e314xoh5t8poc6");

                entity.HasOne(d => d.UserUserStep)
                    .WithOne(p => p.StepsUser)
                    .HasForeignKey<StepsUser>(d => d.UserUserStepId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKs5h5ua89y96bw168ikxuk1iar");
            });

            modelBuilder.Entity<User>(entity =>
            {
                entity.HasKey(e => e.Email)
                    .HasName("PRIMARY");

                entity.ToTable("user");

                entity.HasIndex(e => e.DevCenter)
                    .HasName("FK66gkyoej30vsot453ud2g64jl");

                entity.HasIndex(e => e.Role)
                    .HasName("FKl5alypubd40lwejc45vl35wjb");

                entity.Property(e => e.Email)
                    .HasColumnName("email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.CubeNumber)
                    .HasColumnName("cube_number")
                    .HasColumnType("int(11)");

                entity.Property(e => e.DevCenter)
                    .IsRequired()
                    .HasColumnName("dev_center")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.FistName)
                    .IsRequired()
                    .HasColumnName("fist_name")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.LastName)
                    .IsRequired()
                    .HasColumnName("last_name")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Password)
                    .HasColumnName("password")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Role)
                    .HasColumnName("role")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.HasOne(d => d.DevCenterNavigation)
                    .WithMany(p => p.User)
                    .HasForeignKey(d => d.DevCenter)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK66gkyoej30vsot453ud2g64jl");

                entity.HasOne(d => d.RoleNavigation)
                    .WithMany(p => p.User)
                    .HasForeignKey(d => d.Role)
                    .HasConstraintName("FKl5alypubd40lwejc45vl35wjb");
            });

            modelBuilder.Entity<UserAssignedEquipment>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("user_assigned_equipment");

                entity.HasIndex(e => e.AssignedEquipmentAssetId)
                    .HasName("UK_6grxlhbd3htj5lmumh9lgcowb")
                    .IsUnique();

                entity.HasIndex(e => e.UserEmail)
                    .HasName("FK4fjoasxu0hl4j193jolu146ar");

                entity.Property(e => e.AssignedEquipmentAssetId)
                    .HasColumnName("assigned_equipment_asset_id")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.UserEmail)
                    .IsRequired()
                    .HasColumnName("user_email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.HasOne(d => d.AssignedEquipmentAsset)
                    .WithOne(p => p.UserAssignedEquipment)
                    .HasForeignKey<UserAssignedEquipment>(d => d.AssignedEquipmentAssetId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK5of78uau1hk0wosx2m1kk4f79");

                entity.HasOne(d => d.UserEmailNavigation)
                    .WithMany(p => p.UserAssignedEquipment)
                    .HasForeignKey(d => d.UserEmail)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FK4fjoasxu0hl4j193jolu146ar");
            });

            modelBuilder.Entity<UserStep>(entity =>
            {
                entity.ToTable("user_step");

                entity.HasIndex(e => e.Email)
                    .HasName("FKlg2e0bx8blf48l49yh2efwobs");

                entity.HasIndex(e => e.StepId)
                    .HasName("FKp77qtgc8kjcn6yp6bd4ra8ukf");

                entity.Property(e => e.UserStepId)
                    .HasColumnName("user_step_id")
                    .HasColumnType("bigint(20)");

                entity.Property(e => e.Complete)
                    .HasColumnName("complete")
                    .HasColumnType("bit(1)");

                entity.Property(e => e.Email)
                    .HasColumnName("email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Pending)
                    .HasColumnName("pending")
                    .HasColumnType("bit(1)");

                entity.Property(e => e.StepId)
                    .HasColumnName("step_id")
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.EmailNavigation)
                    .WithMany(p => p.UserStep)
                    .HasForeignKey(d => d.Email)
                    .HasConstraintName("FKlg2e0bx8blf48l49yh2efwobs");

                entity.HasOne(d => d.Step)
                    .WithMany(p => p.UserStep)
                    .HasForeignKey(d => d.StepId)
                    .HasConstraintName("FKp77qtgc8kjcn6yp6bd4ra8ukf");
            });

            modelBuilder.Entity<UserUserSteps>(entity =>
            {
                entity.HasNoKey();

                entity.ToTable("user_user_steps");

                entity.HasIndex(e => e.UserEmail)
                    .HasName("FKdx0x76lrkd23fhc9grkrsjqra");

                entity.HasIndex(e => e.UserStepsUserStepId)
                    .HasName("UK_soal4oymiv1wuh1dudc035q4k")
                    .IsUnique();

                entity.Property(e => e.UserEmail)
                    .IsRequired()
                    .HasColumnName("user_email")
                    .HasColumnType("varchar(255)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.UserStepsUserStepId)
                    .HasColumnName("user_steps_user_step_id")
                    .HasColumnType("bigint(20)");

                entity.HasOne(d => d.UserEmailNavigation)
                    .WithMany(p => p.UserUserSteps)
                    .HasForeignKey(d => d.UserEmail)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKdx0x76lrkd23fhc9grkrsjqra");

                entity.HasOne(d => d.UserStepsUserStep)
                    .WithOne(p => p.UserUserSteps)
                    .HasForeignKey<UserUserSteps>(d => d.UserStepsUserStepId)
                    .OnDelete(DeleteBehavior.ClientSetNull)
                    .HasConstraintName("FKkbo615uofoc2fpjpmcw6a2j0o");
            });

            modelBuilder.Entity<UserData>(entity =>
            {
                entity.HasKey(e => e.UserId)
                    .HasName("PRIMARY");

                entity.ToTable("userdata");

                entity.Property(e => e.UserId)
                    .HasColumnType("varchar(64)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.EmailAddress)
                    .HasColumnType("varchar(45)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.FirstName)
                    .HasColumnType("varchar(45)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.LastName)
                    .HasColumnType("varchar(45)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.PictureUrl)
                    .HasColumnName("PictureURL")
                    .HasColumnType("varchar(128)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");

                entity.Property(e => e.Provider)
                    .HasColumnType("varchar(45)")
                    .HasCharSet("utf8mb4")
                    .HasCollation("utf8mb4_0900_ai_ci");
            });

            OnModelCreatingPartial(modelBuilder);
        }

        partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
    }
}
